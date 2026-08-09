package com.coding.InventoryMS.controller;

import com.coding.InventoryMS.dto.ApiResponse;
import com.coding.InventoryMS.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/check-is-in-stock")
    public ResponseEntity<ApiResponse<Boolean>> isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        boolean response = inventoryService.isInStock(skuCode, quantity);
        String message = response ? "Available in inventory" : "Out of stock";
        return ResponseEntity.ok(new ApiResponse<>(response, message, null));
    }
}