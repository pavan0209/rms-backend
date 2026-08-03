package com.coding.ProductMS.dto.request;

import java.math.BigDecimal;

public record ProductRequest(String Id, String name, String description, BigDecimal price) {

}
