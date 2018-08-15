package com.netease.anodot.webhook.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/8/13 11:17.
 *
 * @author Stanley Huang
 */
public class Notification {

    private List<BaseAlert> alerts;

    public Notification() {
        this.alerts = new ArrayList<>();
    }

    public List<BaseAlert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<BaseAlert> alerts) {
        this.alerts = alerts;
    }
}
