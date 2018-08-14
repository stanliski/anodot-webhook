package com.netease.anodot.webhook.entity;

import java.util.List;

/**
 * Created on 2018/8/10 12:27.
 *
 * @author Stanley Huang
 */
public class Events {

    private String Total;
    private String date;
    private List<TopEvent> topEvents;

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<TopEvent> getTopEvents() {
        return topEvents;
    }

    public void setTopEvents(List<TopEvent> topEvents) {
        this.topEvents = topEvents;
    }
}
