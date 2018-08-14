package com.netease.anodot.webhook.entity.staticAlert;

/**
 * Created on 2018/8/10 12:12.
 *
 * @author Stanley Huang
 */
public class StaticMetrics {

    private String duration;
    private String durationInSeconds;
    private String startTime;
    private String startTimeEpoch;
    private String imageUrl;
    private String peak;
    private String direction;
    private String name;
    private String state;
    private String threshold;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPeak() {
        return peak;
    }

    public void setPeak(String peak) {
        this.peak = peak;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }
}
