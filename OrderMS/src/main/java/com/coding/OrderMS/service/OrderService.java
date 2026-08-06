package com.coding.OrderMS.service;


import com.coding.OrderMS.dto.request.OrderRequest;

public interface OrderService {

    boolean placeOrder(OrderRequest request);
}
