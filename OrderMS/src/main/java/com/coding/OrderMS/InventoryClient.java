package com.coding.OrderMS;

import com.coding.OrderMS.dto.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory", url = "${inventory.url}")
public interface InventoryClient {

    @GetMapping("/api/inventory/check-is-in-stock")
    ApiResponse<Boolean> isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
