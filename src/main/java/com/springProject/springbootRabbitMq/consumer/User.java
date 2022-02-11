package com.springProject.springbootRabbitMq.consumer;

import com.springProject.springbootRabbitMq.config.MessagingConfig;
import com.springProject.springbootRabbitMq.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
public void consumeMessagefromQueue(OrderStatus orderStatus){
    System.out.println("The message is received from Queue"+orderStatus);

}

}
