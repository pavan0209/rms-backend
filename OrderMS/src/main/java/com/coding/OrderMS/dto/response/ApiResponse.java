package com.coding.OrderMS.dto.response;

public record ApiResponse<T>(boolean status, String message, T data) {

}