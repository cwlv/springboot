package com.springboot.service.impl;

import com.springboot.common.ResultJson;
import com.springboot.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service("mailService")
public class MailServiceImpl implements MailService {

    private final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
    @Value("${application.fromMail}")
    private String sender;      //发件人

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public ResultJson sendTextMail(String receiver, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(text);
        try {
            this.mailSender.send(message);
            logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
            return new ResultJson("发送简单邮件时发生异常！");
        }
        return new ResultJson();
    }

    @Override
    public ResultJson sendHtmlMail(String receiver, String subject, String content) {
//        String content="<html>\n" +
//                "<body>\n" +
//                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
//                "</body>\n" +
//                "</html>";
        MimeMessage message = this.mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(content, true);

            this.mailSender.send(message);
            logger.info("html邮件发送成功");
        } catch (MessagingException e) {
            logger.error("发送html邮件时发生异常！", e);
            return new ResultJson("发送html邮件时发生异常！");
        }

        return new ResultJson();
    }
}
