package com.springboot.service;

import com.springboot.common.ResultJson;

/**
 * 邮件服务 接口
 */
public interface MailService {

    public ResultJson sendTextMail(String receiver,String subject,String text);

    public ResultJson sendHtmlMail(String receiver,String subject,String text);
}
