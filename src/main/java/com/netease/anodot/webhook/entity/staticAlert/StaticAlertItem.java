package com.netease.anodot.webhook.entity.staticAlert;

import com.netease.anodot.webhook.entity.anomaly.AlertItem;

import java.util.List;

/**
 * Created on 2018/8/10 12:07.
 *
 * @author Stanley Huang
 */
public class StaticAlertItem extends AlertItem {

    private List<StaticMetrics> metrics;

    public List<StaticMetrics> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<StaticMetrics> metrics) {
        this.metrics = metrics;
    }
}
