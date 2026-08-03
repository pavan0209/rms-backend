package com.coding.ProductMS.service;

import com.coding.ProductMS.dto.request.ProductRequest;
import com.coding.ProductMS.dto.response.ProductResponse;
import com.coding.ProductMS.entity.Product;
import com.coding.ProductMS.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Product product = Product
                .builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();

        Product saved = productRepository.save(product);
        log.info("Product created successfully");

        return new ProductResponse(saved.getId(), saved.getName(), saved.getDescription(), saved.getPrice());
    }
}
