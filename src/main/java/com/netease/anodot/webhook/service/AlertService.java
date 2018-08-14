package com.netease.anodot.webhook.service;

import com.netease.anodot.webhook.entity.BaseAlert;

import java.util.List;

/**
 * Created on 2018/8/10 12:43.
 *
 * @author Stanley Huang
 */
public interface AlertService {
    BaseAlert addAlert(BaseAlert alert);

    List<BaseAlert> listAlertsByTime(String startTime, String endTime);
}
