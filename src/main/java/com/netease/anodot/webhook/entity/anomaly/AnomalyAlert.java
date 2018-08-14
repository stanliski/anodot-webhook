package com.netease.anodot.webhook.entity.anomaly;

import com.netease.anodot.webhook.entity.BaseAlert;

import java.util.List;

/**
 * Created on 2018/8/10 11:27.
 *
 * @author Stanley Huang
 */

public class AnomalyAlert extends BaseAlert {
    private String investigationUrl;
    private String anomalyId;
    private String timeScale;
    private List<AnomalyAlertItem> alerts;
    private String mergedAnomalies;

    public String getTimeScale() {
        return timeScale;
    }

    public void setTimeScale(String timeScale) {
        this.timeScale = timeScale;
    }

    public String getInvestigationUrl() {
        return investigationUrl;
    }

    public void setInvestigationUrl(String investigationUrl) {
        this.investigationUrl = investigationUrl;
    }

    public String getAnomalyId() {
        return anomalyId;
    }

    public void setAnomalyId(String anomalyId) {
        this.anomalyId = anomalyId;
    }

    public List<AnomalyAlertItem> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<AnomalyAlertItem> alerts) {
        this.alerts = alerts;
    }

    public String getMergedAnomalies() {
        return mergedAnomalies;
    }

    public void setMergedAnomalies(String mergedAnomalies) {
        this.mergedAnomalies = mergedAnomalies;
    }

    @Override
    public String toString() {
        return "AnomalyAlert{" +
                "investigationUrl='" + investigationUrl + '\'' +
                ", anomalyId='" + anomalyId + '\'' +
                ", timeScale='" + timeScale + '\'' +
                ", alerts=" + alerts +
                ", mergedAnomalies='" + mergedAnomalies + '\'' +
                '}';
    }
}
