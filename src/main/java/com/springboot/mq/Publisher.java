package com.springboot.mq;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * 发布者  一对多
 * 需要先订阅，发布的消息才能被接收，也就是发布的消息不会保存在队列中
 */
@Service
public class Publisher {

    private final Logger log = LoggerFactory.getLogger(Publisher.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void publisher(String destinationName,String message){
        log.info("发布topic消息：" + message);
        Destination destination = new ActiveMQTopic(destinationName);
        this.jmsMessagingTemplate.convertAndSend(destination,message);
    }
}
