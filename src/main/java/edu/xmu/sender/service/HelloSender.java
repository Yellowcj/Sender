package edu.xmu.sender.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: YellowPure
 * @Description: 使用AmqpTemplate去发送消息
 * @Date: Created in 20:55 2017/11/8
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate template;

    public void send(){
        template.convertAndSend("queue", "hello, rabbit");
    }

    public void topicSend(){
        template.convertAndSend("exchange", "topic.message", "publish topic");
    }
}
