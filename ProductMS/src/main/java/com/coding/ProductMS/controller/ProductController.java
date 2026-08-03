package com.coding.ProductMS.controller;

import com.coding.ProductMS.dto.request.ProductRequest;
import com.coding.ProductMS.dto.response.ApiResponse;
import com.coding.ProductMS.dto.response.ProductResponse;
import com.coding.ProductMS.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add-product")
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(@Valid @RequestBody ProductRequest request) {

        ProductResponse response = productService.createProduct(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Product created successfully.", response));
    }

    @GetMapping("/get-products")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getProducts() {
        List<ProductResponse> response = productService.getProducts();
        return ResponseEntity.ok(new ApiResponse<>(true, "Products fetched successfully.", response));
    }
}
