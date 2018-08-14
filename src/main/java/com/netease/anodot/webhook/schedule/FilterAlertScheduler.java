package com.netease.anodot.webhook.schedule;

import com.netease.anodot.webhook.entity.BaseAlert;
import com.netease.anodot.webhook.entity.Notification;
import com.netease.anodot.webhook.entity.user.UserGroup;
import com.netease.anodot.webhook.service.AlertService;
import com.netease.anodot.webhook.service.TopEventService;
import com.netease.anodot.webhook.service.UserGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created on 2018/8/13 10:02.
 *
 * @author Stanley Huang
 */
@Component
public class FilterAlertScheduler {

    private static Logger logger = LoggerFactory.getLogger(FilterAlertScheduler.class);
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private AlertService alertService;
    private TopEventService topEventService;
    private UserGroupService userGroupService;
    private Map<String, Notification> notiMap = new HashMap<>();
    private final static long PERIODIC_SECONDS = 300000;

    @Autowired
    public FilterAlertScheduler(AlertService alertService,
                                TopEventService topEventService,
                                UserGroupService userGroupService) {
        this.alertService = alertService;
        this.topEventService = topEventService;
        this.userGroupService = userGroupService;
    }

    @Scheduled(cron = "0/300 * * * * ? ")   //每300秒执行一次
    public void filterLoop() {
        logger.info("Filter alerts loop happened in " + dateFormat.format(new Date()));
        long currentTimestamp = new Date().getTime();
        long startTimestamp = currentTimestamp - PERIODIC_SECONDS;
        String currentTime = dateFormat.format(currentTimestamp);
        String startTime = dateFormat.format(startTimestamp);
        List<BaseAlert> alertList = alertService.listAlertsByTime(startTime, currentTime);
        for (int i = 0; i < alertList.size(); i++) {
            BaseAlert alert = alertList.get(i);
            Notification notification;
            if (notiMap.containsKey(alert.getStartTime())) {
                notification = notiMap.get(alert.getStartTime());
                notification.getAlerts().add(alert);
            } else {
                notification = new Notification();
                notiMap.put(alert.getStartTime(), notification);
            }
        }
        sendNotification();
    }

    private void sendNotification() {
        UserGroup userGroup = userGroupService.getUserGroup();
        for (String key : notiMap.keySet()) {
            Notification notis = notiMap.get(key);
            String content = "Happened in " + key + "\n";
            if (notis != null && notis.getAlerts() != null) {
                for (BaseAlert alert : notis.getAlerts()) {
                    content += alert.toString() + "\n";
                }
                logger.info(content);
//                popoService.popoNotify(userGroup.getEmails(), content);
            }
        }
    }

}
