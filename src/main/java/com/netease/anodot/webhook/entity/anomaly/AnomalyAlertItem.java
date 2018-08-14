package com.netease.anodot.webhook.entity.anomaly;

import com.netease.anodot.webhook.entity.Bucket;

import java.util.List;

/**
 * Created on 2018/8/10 11:56.
 *
 * @author Stanley Huang
 */
public class AnomalyAlertItem extends AlertItem {

    private List<AnomalyMetrics> metrics;
    private List<Bucket> buckets;

    public List<Bucket> getBuckets() {
        return buckets;
    }

    public void setBuckets(List<Bucket> buckets) {
        this.buckets = buckets;
    }

    public List<AnomalyMetrics> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<AnomalyMetrics> metrics) {
        this.metrics = metrics;
    }
}
