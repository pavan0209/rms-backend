package com.coding.ProductMS.dto.response;

public record ApiResponse<T>(boolean status, String message, T data) {

}