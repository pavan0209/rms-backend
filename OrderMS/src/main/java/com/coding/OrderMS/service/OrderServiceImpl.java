package com.coding.OrderMS.service;

import com.coding.OrderMS.dto.request.OrderRequest;
import com.coding.OrderMS.entity.Order;
import com.coding.OrderMS.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void placeOrder(OrderRequest request) {

        Order order = Order
                .builder()
                .orderNumber(UUID.randomUUID().toString())
                .price(request.price())
                .skuCode(request.skuCode())
                .quantity(request.quantity())
                .build();

        orderRepository.save(order);
    }
}
