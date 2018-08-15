package com.netease.anodot.webhook.service.impl;

import com.netease.anodot.webhook.email.EmailHtmlSender;
import com.netease.anodot.webhook.entity.AlertType;
import com.netease.anodot.webhook.entity.BaseAlert;
import com.netease.anodot.webhook.entity.Notification;
import com.netease.anodot.webhook.entity.report.ReportGenerator;
import com.netease.anodot.webhook.service.EmailService;
import com.netease.anodot.webhook.service.UserGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created on 2018/8/15 11:20.
 *
 * @author Stanley Huang
 */

@Service
public class EmailServiceImpl implements EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private EmailHtmlSender emailHtmlSender;

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private ReportGenerator reportGenerator;

    @Async
    @Override
    public void sendEmail(List<String> emails, Notification notification) {
        List<BaseAlert> alerts = notification.getAlerts();
        if (alerts.size() == 0) {
            logger.error("body is empty, seems to something was happened!");
            return;
        }
        String body = reportGenerator.generateReport(AlertType.ANOMALY, alerts);
        for (String email : emails) {
            emailHtmlSender.send(email, notification.getSubject(), body);
            try {
                // 发送的太快会报异常
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("Sleep for 1000ms to send email" + e.toString());
            }
        }
    }
}
