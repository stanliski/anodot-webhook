package com.netease.anodot.webhook.entity.nodata;

import com.netease.anodot.webhook.entity.Bucket;
import com.netease.anodot.webhook.entity.anomaly.AlertItem;

import java.util.List;

/**
 * Created on 2018/8/10 11:57.
 *
 * @author Stanley Huang
 */
public class NoDataAlertItem extends AlertItem {
    private List<NoDataMetrics> metrics;
    private List<Bucket> buckets;

    public List<Bucket> getBuckets() {
        return buckets;
    }

    public void setBuckets(List<Bucket> buckets) {
        this.buckets = buckets;
    }

    public List<NoDataMetrics> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<NoDataMetrics> metrics) {
        this.metrics = metrics;
    }
}
