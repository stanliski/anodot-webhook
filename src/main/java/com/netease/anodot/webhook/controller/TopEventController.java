package com.netease.anodot.webhook.controller;

import com.netease.anodot.webhook.entity.ResponseContent;
import com.netease.anodot.webhook.entity.TopEvent;
import com.netease.anodot.webhook.service.TopEventService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created on 2018/8/15 20:27.
 *
 * @author Stanley Huang
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/event")
public class TopEventController {
    private static final Logger logger = LoggerFactory.getLogger(UserGroupController.class);
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");

    @Autowired
    private TopEventService topEventService;

    @ApiOperation(value = "添加一个事件", notes = "添加一个事件")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseContent<TopEvent> addTopEvent(@RequestBody TopEvent topEvent) {
        TopEvent newTopEvent = topEventService.addEvent(topEvent);
        return new ResponseContent<>(true, newTopEvent, "");
    }

    @ApiOperation(value = "获取所有事件", notes = "获取所有事件")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseContent<List<TopEvent>> getAllEvents() {
        List<TopEvent> topEvents = topEventService.getAllEvents();
        return new ResponseContent<>(true, topEvents, "");
    }

}
