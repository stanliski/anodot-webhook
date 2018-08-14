package com.netease.anodot.webhook.service.impl;

import com.netease.anodot.webhook.entity.BaseAlert;
import com.netease.anodot.webhook.repository.AlertRepository;
import com.netease.anodot.webhook.service.AlertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2018/8/10 12:44.
 *
 * @author Stanley Huang
 */

@Service
public class AlertServiceImpl implements AlertService {
    private static final Logger logger = LoggerFactory.getLogger(AlertServiceImpl.class);

    @Autowired
    private AlertRepository alertRepository;

    @Override
    public BaseAlert addAlert(BaseAlert alert) {
        return alertRepository.insert(alert);
    }

    public List<BaseAlert> getAlerts() {

        return null;
    }

}
