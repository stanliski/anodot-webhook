package com.netease.anodot.webhook.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/8/13 11:17.
 *
 * @author Stanley Huang
 */
public class Notification {
    private String time;
    private String subject;
    private AlertType alertType;
    private List<BaseAlert> alerts;

    public Notification() {
        this.alerts = new ArrayList<>();
    }

    public Notification(String time, String subject) {
        this();
        this.time = time;
        this.subject = subject;
        this.alertType = AlertType.ANOMALY;
    }

    public Notification(String time, String subject, AlertType alertType) {
        this(time, subject);
        this.alertType = alertType;
    }

    public AlertType getAlertType() {
        return alertType;
    }

    public void setAlertType(AlertType alertType) {
        this.alertType = alertType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<BaseAlert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<BaseAlert> alerts) {
        this.alerts = alerts;
    }
}
