package com.netease.anodot.webhook.entity;

/**
 * Created on 2018/8/13 11:27.
 *
 * @author Stanley Huang
 */
public enum AlertType {

    STATIC("static"),
    NO_DATA("no_data"),
    ANOMALY("anomaly");

    private String name;

    AlertType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
