package com.netease.anodot.webhook.entity.anomaly;

/**
 * Created on 2018/8/10 11:33.
 *
 * @author Stanley Huang
 */

public class AlertItem {
    private String title;
    private String alertId;
    private String alertSettingsUrl;
    private String description;
    private String severity;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public String getAlertSettingsUrl() {
        return alertSettingsUrl;
    }

    public void setAlertSettingsUrl(String alertSettingsUrl) {
        this.alertSettingsUrl = alertSettingsUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
