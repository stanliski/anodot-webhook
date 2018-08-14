package com.netease.anodot.webhook.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created on 2018/8/10 11:27.
 *
 * @author Stanley Huang
 */


@Document(collection = "alerts")
public class BaseAlert {

    private String subject;
    private String severity;
    private String description;
    private String startTime;
    private String startTimeEpoch;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTimeEpoch() {
        return startTimeEpoch;
    }

    public void setStartTimeEpoch(String startTimeEpoch) {
        this.startTimeEpoch = startTimeEpoch;
    }

    @Override
    public String toString() {
        return "BaseAlert{" +
                "subject='" + subject + '\'' +
                ", severity='" + severity + '\'' +
                ", description='" + description + '\'' +
                ", startTime='" + startTime + '\'' +
                ", startTimeEpoch='" + startTimeEpoch + '\'' +
                '}';
    }
}
