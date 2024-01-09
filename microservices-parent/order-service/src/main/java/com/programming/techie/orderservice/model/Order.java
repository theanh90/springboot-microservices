package com.programming.techie.orderservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "t_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;
}
