package com.coding.OrderMS.controller;

import com.coding.OrderMS.dto.request.OrderRequest;
import com.coding.OrderMS.dto.response.ApiResponse;
import com.coding.OrderMS.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create-order")
    public ResponseEntity<ApiResponse<Void>> placeOrder(@Valid @RequestBody OrderRequest request) {
        orderService.placeOrder(request);
        return ResponseEntity.ok(new ApiResponse<>(true, "Order created successfully.", null));
    }
}
