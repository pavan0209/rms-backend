package com.coding.InventoryMS.service;

public interface InventoryService {

    boolean isInStock(String skuCode, Integer quantity);
}
