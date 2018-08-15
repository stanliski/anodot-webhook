package com.netease.anodot.webhook.service.impl;

import com.netease.anodot.webhook.email.EmailHtmlSender;
import com.netease.anodot.webhook.entity.BaseAlert;
import com.netease.anodot.webhook.entity.Notification;
import com.netease.anodot.webhook.entity.anomaly.AnomalyAlert;
import com.netease.anodot.webhook.entity.anomaly.AnomalyAlertItem;
import com.netease.anodot.webhook.entity.anomaly.AnomalyMetrics;
import com.netease.anodot.webhook.entity.report.ReportGenerator;
import com.netease.anodot.webhook.entity.user.UserGroup;
import com.netease.anodot.webhook.service.EmailService;
import com.netease.anodot.webhook.service.UserGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created on 2018/8/15 11:20.
 *
 * @author Stanley Huang
 */

@Service
public class EmailServiceImpl implements EmailService {
    private static final String ANOMALY = "anomaly";
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private EmailHtmlSender emailHtmlSender;

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private ReportGenerator reportGenerator;

    @Override
    public void sendEmail(List<String> emails, Notification notification) {
        List<BaseAlert> alerts = notification.getAlerts();
        List<AnomalyMetrics> metricsList = new ArrayList();
        for (BaseAlert alert : alerts) {
            AnomalyAlert anomalyAlert = (AnomalyAlert) alert;
            List<AnomalyAlertItem> alertItems = anomalyAlert.getAlerts();
            if (alertItems.size() > 0) {
                AnomalyAlertItem item = alertItems.get(0);
                metricsList.addAll(item.getMetrics());
            }
        }
        for (String email : emails) {
            String body = reportGenerator.getAnomalyReport(metricsList);
            logger.info("send email to {}", email);
            emailHtmlSender.send(email, "test email", body);
        }
    }
}
