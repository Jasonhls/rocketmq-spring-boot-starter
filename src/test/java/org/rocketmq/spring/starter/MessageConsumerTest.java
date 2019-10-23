package org.rocketmq.spring.starter;

import org.rocketmq.starter.annotation.RocketMQListener;
import org.rocketmq.starter.annotation.RocketMQMessage;
import org.rocketmq.starter.core.consumer.MessageContext;
import org.springframework.stereotype.Component;

/**
 * @author: helisen
 * @create: 2019/10/22 10:41
 * @description:
 */
@Component
@RocketMQListener(topic = "topic-test",retryTimes = 3)
public class MessageConsumerTest {

    @RocketMQMessage(tag = "TagA",messageClass = org.rocketmq.spring.starter.Product.class)
    public Product consumerMessage(Product product,MessageContext messageContext){
        System.out.println("消费消息");
        return null;
    }

    @RocketMQMessage(tag = "TagB",messageClass = String.class)
    public Product consumerMessageTwo(String string,MessageContext messageContext){
        System.out.println("消费消息");
        return null;
    }
}
