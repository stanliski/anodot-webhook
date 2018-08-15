package com.netease.anodot.webhook.service;

import com.netease.anodot.webhook.entity.Notification;

import java.util.List;

/**
 * Created on 2018/8/15 11:20.
 *
 * @author Stanley Huang
 */
public interface EmailService {

    void sendEmail(List<String> emails, Notification notification);

}
