package com.springProject.springbootRabbitMq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class order {
    private String id;
    private String name;
    private int qty;
    private double price;

}
