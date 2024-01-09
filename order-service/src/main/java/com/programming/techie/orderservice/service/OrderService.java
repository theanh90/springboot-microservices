package com.programming.techie.orderservice.service;

import com.programming.techie.orderservice.dto.OrderRequest;
import com.programming.techie.orderservice.model.Order;
import com.programming.techie.orderservice.model.OrderLineItems;
import com.programming.techie.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> items = orderRequest.getOrderLineItemsDtoList().stream().map(itemDto -> {
            return OrderLineItems.builder()
                    .price(itemDto.getPrice())
                    .quantity(itemDto.getQuantity())
                    .skuCode(itemDto.getSkuCode())
                    .build();
        }).toList();
        order.setOrderLineItemsList(items);

        // save to database
        orderRepository.save(order);
    }
}
