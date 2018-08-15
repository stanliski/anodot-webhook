package com.netease.anodot.webhook.entity.report;

import com.netease.anodot.webhook.entity.AlertType;
import com.netease.anodot.webhook.entity.BaseAlert;
import com.netease.anodot.webhook.entity.EmailTemplate;
import com.netease.anodot.webhook.entity.anomaly.AnomalyAlert;
import com.netease.anodot.webhook.entity.anomaly.AnomalyAlertItem;
import com.netease.anodot.webhook.entity.anomaly.AnomalyMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/8/14 16:02.
 *
 * @author Stanley Huang
 */
@Component
public class ReportGenerator {
    private static final Logger logger = LoggerFactory.getLogger(ReportGenerator.class);
    private static final String EMAIL_ANOMALY_TEMPLATE = "anomaly-template";
    private TemplateEngine templateEngine;

    @Autowired
    public ReportGenerator(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String generateReport(AlertType alertType, List<BaseAlert> alerts) {
        if (AlertType.ANOMALY.equals(alertType)) {
            return generateAnomalyReport(alerts);
        } else if (AlertType.NO_DATA.equals(alertType)) {
            return generateNoDataReport(alerts);
        } else if (AlertType.STATIC.equals(alertType)) {
            return generateStaticReport(alerts);
        }
        return "";
    }

    private String generateAnomalyReport(List<BaseAlert> alerts) {
        Context context = new Context();
        List<EmailTemplate> templateItemList = new ArrayList();
        for (BaseAlert alert : alerts) {
            EmailTemplate templateItem = new EmailTemplate();
            AnomalyAlert anomalyAlert = (AnomalyAlert) alert;
            templateItem.setInvestigationUrl(anomalyAlert.getInvestigationUrl());
            templateItem.setSeverity(anomalyAlert.getSeverity());
            templateItem.setTimeScale(anomalyAlert.getTimeScale());
            templateItem.setSubject(anomalyAlert.getSubject());

            List<AnomalyAlertItem> alertItems = anomalyAlert.getAlerts();
            if (alertItems != null && alertItems.size() > 0) {
                for (AnomalyAlertItem item : alertItems) {
                    if (item.getMetrics() != null && item.getMetrics().size() > 0) {
                        for (AnomalyMetrics anomalyMetrics : item.getMetrics())
                            templateItem.getAnomalyMetrics().add(anomalyMetrics);
                    }
                }
            }
            templateItemList.add(templateItem);
        }
        context.setVariable("templateItemList", templateItemList);
        String html = templateEngine.process(EMAIL_ANOMALY_TEMPLATE, context);
        return html;
    }


    private String generateStaticReport(List<BaseAlert> alerts) {
        //TO-DO
        return "";
    }

    private String generateNoDataReport(List<BaseAlert> alerts) {
        //TO-DO
        return "";
    }

}
