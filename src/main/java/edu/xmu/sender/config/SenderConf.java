package edu.xmu.sender.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author: YellowPure
 * @Description: 配置消息队列
 * @Date: Created in 20:47 2017/11/8
 */
@Configuration
public class SenderConf {
    @Bean
    public Queue queue(){
        /**
         * 注意由于采用的是Direct模式
         *需要在配置Queue的时候指定一个键
         *使其和交换机绑定
         */
        return new Queue("queue");
    }

    @Bean(name="message")
    public Queue queueMessage(){
        return new Queue("topic.message");
    }

    @Bean(name="messages")
    public Queue queueMessages(){
        return new Queue("topic.messages");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(@Qualifier("messages") Queue queueMessages, TopicExchange exchange) {
        //*表示一个词,#表示零个或多个词
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
