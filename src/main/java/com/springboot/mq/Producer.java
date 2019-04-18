package com.springboot.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * 生产者  queue 点对点
 * 生产的消息，会保存在队列中，如果有多个消费者，轮流接收消息
 */

@Service
public class Producer {

    private final Logger log = LoggerFactory.getLogger(Producer.class);

    //注入jsmtemplate
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMsg(String destinationName,String message) {
        log.info("发送queue消息：" + message);
        Destination destination = new ActiveMQQueue(destinationName);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

}
