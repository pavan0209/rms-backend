package com.coding.ProductMS.repository;

import com.coding.ProductMS.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
