package com.coding.OrderMS.service;

import com.coding.OrderMS.InventoryClient;
import com.coding.OrderMS.dto.request.OrderRequest;
import com.coding.OrderMS.dto.response.ApiResponse;
import com.coding.OrderMS.entity.Order;
import com.coding.OrderMS.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final InventoryClient inventoryClient;

    @Override
    public boolean placeOrder(OrderRequest request) {

        ApiResponse<Boolean> response = inventoryClient.isInStock(request.skuCode(), request.quantity());
        log.info("#### RESPONSE:: {}", response);
        if (response.data()) {
            Order order = Order
                    .builder()
                    .orderNumber(UUID.randomUUID().toString())
                    .price(request.price())
                    .skuCode(request.skuCode())
                    .quantity(request.quantity())
                    .build();

            orderRepository.save(order);
            return true;
        } else {
            return false;
        }
    }
}
