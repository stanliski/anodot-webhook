package com.netease.anodot.webhook.service.impl;

import com.netease.anodot.webhook.entity.BaseAlert;
import com.netease.anodot.webhook.repository.AlertRepository;
import com.netease.anodot.webhook.service.AlertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created on 2018/8/10 12:44.
 *
 * @author Stanley Huang
 */

@Service
public class AlertServiceImpl implements AlertService {
    private static final Logger logger = LoggerFactory.getLogger(AlertServiceImpl.class);
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");

    @Autowired
    private AlertRepository alertRepository;

    @Override
    public BaseAlert addAlert(BaseAlert alert) {
        alert.setCreateTime(df.format(new Date()));
        return alertRepository.insert(alert);
    }

    @Override
    public List<BaseAlert> listAlertsByTime(String startTime, String endTime) {
        logger.info("Filter alerts from {} to {} ", startTime, endTime);
        return alertRepository.findByCreateTimeBetween(startTime, endTime);
    }

    public List<BaseAlert> getAlerts() {
        return alertRepository.findAll();
    }

}
