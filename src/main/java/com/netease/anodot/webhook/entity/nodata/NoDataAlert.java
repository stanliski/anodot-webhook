package com.netease.anodot.webhook.entity.nodata;

import com.netease.anodot.webhook.entity.BaseAlert;

import java.util.List;

/**
 * Created on 2018/8/10 11:46.
 *
 * @author Stanley Huang
 */

public class NoDataAlert extends BaseAlert {
    private List<NoDataAlertItem> alerts;

    public List<NoDataAlertItem> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<NoDataAlertItem> alerts) {
        this.alerts = alerts;
    }
}
