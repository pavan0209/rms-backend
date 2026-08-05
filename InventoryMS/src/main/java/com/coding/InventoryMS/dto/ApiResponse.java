package com.coding.InventoryMS.dto;

public record ApiResponse<T>(boolean status, String message, T data) {

}