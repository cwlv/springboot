package com.springboot.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * 消费者  queue 点对点
 */
@Service
public class Consumer {

    @JmsListener(destination = "test.queue")
    public void readMsg(String text) {
        System.out.println("接收到消息：" + text);
    }

}
