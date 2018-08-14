package com.netease.anodot.webhook.entity.nodata;

/**
 * Created on 2018/8/10 11:50.
 *
 * @author Stanley Huang
 */
public class NoDataMetrics {

    private String lastSeen;
    private String lastSeenEpoch;
    private String duration;
    private String durationInSeconds;
    private String startTime;
    private String startTimeEpoch;
    private String name;
    private String state;

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getLastSeenEpoch() {
        return lastSeenEpoch;
    }

    public void setLastSeenEpoch(String lastSeenEpoch) {
        this.lastSeenEpoch = lastSeenEpoch;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(String durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
