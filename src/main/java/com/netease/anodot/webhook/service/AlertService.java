package com.netease.anodot.webhook.service;

import com.netease.anodot.webhook.entity.BaseAlert;

/**
 * Created on 2018/8/10 12:43.
 *
 * @author Stanley Huang
 */
public interface AlertService {
    BaseAlert addAlert(BaseAlert alert);
}
