package com.coding.OrderMS.repository;

import com.coding.OrderMS.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
