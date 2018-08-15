package com.netease.anodot.webhook.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/**
 * Created on 2018/8/15 11:14.
 *
 * @author Stanley Huang
 */
@Component
public class EmailSender {

    private static final Logger logger = LoggerFactory.getLogger(EmailSender.class);

    @Autowired
    private JavaMailSender mailSender;

    public EmailStatus sendPlainText(String to, String subject, String text) {
        return sendM(to, subject, text, false);
    }

    public EmailStatus sendHtml(String to, String subject, String htmlBody) {
        return sendM(to, subject, htmlBody, true);
    }

    private EmailStatus sendM(String to, String subject, String text, Boolean isHtml) {
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setFrom("1015757334@qq.com");
            helper.setSubject(subject);
            helper.setText(text, isHtml);
            mailSender.send(mail);
            logger.info("Send email {} to: {}", subject, to);
            return new EmailStatus(to, subject, text).success();
        } catch (Exception e) {
            logger.error("Problem with sending email to: {}, error message: {}", to, e.getMessage());
            return new EmailStatus(to, subject, text).error(e.getMessage());
        }
    }
}

