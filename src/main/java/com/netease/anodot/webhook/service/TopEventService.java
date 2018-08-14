package com.netease.anodot.webhook.service;

import com.netease.anodot.webhook.entity.TopEvent;

import java.util.List;

/**
 * Created on 2018/8/13 10:39.
 *
 * @author Stanley Huang
 */
public interface TopEventService {

    TopEvent addEvent(TopEvent event);

    List<TopEvent> getAllEvents();

}
