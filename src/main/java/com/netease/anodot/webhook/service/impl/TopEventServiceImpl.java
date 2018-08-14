package com.netease.anodot.webhook.service.impl;

import com.netease.anodot.webhook.entity.TopEvent;
import com.netease.anodot.webhook.repository.TopEventRepository;
import com.netease.anodot.webhook.service.TopEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2018/8/13 10:39.
 *
 * @author Stanley Huang
 */
@Service
public class TopEventServiceImpl implements TopEventService {
    private static final Logger logger = LoggerFactory.getLogger(TopEventServiceImpl.class);
    private TopEventRepository topEventRepository;

    @Autowired
    public TopEventServiceImpl(TopEventRepository topEventRepository) {
        this.topEventRepository = topEventRepository;
    }

    @Override
    public TopEvent addEvent(TopEvent event) {
        return topEventRepository.insert(event);
    }

    @Override
    public List<TopEvent> getAllEvents() {
        return topEventRepository.findAll();
    }

}
