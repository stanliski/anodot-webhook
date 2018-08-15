package com.netease.anodot.webhook.entity.report;

import com.netease.anodot.webhook.entity.anomaly.AnomalyMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

/**
 * Created on 2018/8/14 16:02.
 *
 * @author Stanley Huang
 */

@Component
public class ReportGenerator {

    @Autowired
    private TemplateEngine templateEngine;

    private static final String EMAIL_TEMPLATE = "anomaly-template";

    public String getAnomalyReport(List<AnomalyMetrics> metricsList) {
        Context context = new Context();
        context.setVariable("metricsList", metricsList);
        String html = templateEngine.process(EMAIL_TEMPLATE, context);
        return html;
    }

}
