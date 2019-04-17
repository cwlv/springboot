package com.springboot.controller.admin;

import com.springboot.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/email")
public class MailController {

    private final Logger logger = LoggerFactory.getLogger(MailController.class);

    @Autowired
    private MailService mailService;

    @RequestMapping("/sendTextMail")
    public String sendTextMail(){

        this.mailService.sendTextMail("cwlv_ly@163.com","文本邮件","测试文本邮件");

        return "success";
    }


}
