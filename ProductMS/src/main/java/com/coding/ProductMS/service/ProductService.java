package com.coding.ProductMS.service;

import com.coding.ProductMS.dto.request.ProductRequest;
import com.coding.ProductMS.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest request);

    List<ProductResponse> getProducts();
}
