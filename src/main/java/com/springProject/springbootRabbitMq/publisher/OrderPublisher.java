package com.springProject.springbootRabbitMq.publisher;

import com.springProject.springbootRabbitMq.config.MessagingConfig;
import com.springProject.springbootRabbitMq.dto.OrderStatus;
import com.springProject.springbootRabbitMq.dto.order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

@PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody order order, String restaurantname)
    {
     order.setId(UUID.randomUUID().toString());
        OrderStatus orderStatus=new OrderStatus(order,"Process","Delivery in process");
      template.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,orderStatus);
   return"success";
    }

}
