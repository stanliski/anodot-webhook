package com.netease.anodot.webhook.entity;

import com.netease.anodot.webhook.entity.anomaly.AnomalyMetrics;
import com.netease.anodot.webhook.entity.nodata.NoDataMetrics;
import com.netease.anodot.webhook.entity.staticAlert.StaticMetrics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/8/15 18:38.
 *
 * @author Stanley Huang
 */
public class EmailTemplate {
    private String subject;
    private String timeScale;
    private String severity;
    private String investigationUrl;
    private List<AnomalyMetrics> anomalyMetrics;
    private List<NoDataMetrics> noDataMetrics;
    private List<StaticMetrics> staticMetrics;

    public EmailTemplate() {
        this.anomalyMetrics = new ArrayList<>();
        this.noDataMetrics = new ArrayList<>();
        this.staticMetrics = new ArrayList<>();
    }

    public List<AnomalyMetrics> getAnomalyMetrics() {
        return anomalyMetrics;
    }

    public void setAnomalyMetrics(List<AnomalyMetrics> anomalyMetrics) {
        this.anomalyMetrics = anomalyMetrics;
    }

    public List<NoDataMetrics> getNoDataMetrics() {
        return noDataMetrics;
    }

    public void setNoDataMetrics(List<NoDataMetrics> noDataMetrics) {
        this.noDataMetrics = noDataMetrics;
    }

    public List<StaticMetrics> getStaticMetrics() {
        return staticMetrics;
    }

    public void setStaticMetrics(List<StaticMetrics> staticMetrics) {
        this.staticMetrics = staticMetrics;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTimeScale() {
        return timeScale;
    }

    public void setTimeScale(String timeScale) {
        this.timeScale = timeScale;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getInvestigationUrl() {
        return investigationUrl;
    }

    public void setInvestigationUrl(String investigationUrl) {
        this.investigationUrl = investigationUrl;
    }

}
