package com.netease.anodot.webhook.entity.staticAlert;

import com.netease.anodot.webhook.entity.BaseAlert;

import java.util.List;

/**
 * Created on 2018/8/10 12:24.
 *
 * @author Stanley Huang
 */

public class StaticAlert extends BaseAlert {

    private List<StaticAlertItem> alerts;

    public List<StaticAlertItem> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<StaticAlertItem> alerts) {
        this.alerts = alerts;
    }
}
