package com.netease.anodot.webhook.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 2018/8/15 11:16.
 *
 * @author Stanley Huang
 */
@Component
public class EmailHtmlSender {

    @Autowired
    private EmailSender emailSender;

    public EmailStatus send(String to, String subject, String body) {
//        String body = templateEngine.process(templateName, context);
        return emailSender.sendHtml(to, subject, body);
    }
}
