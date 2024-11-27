package org.example.qlkv.DTO;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private T data;
    private String message;

    public ApiResponse(String message, T data) {
        this.data = data;
        this.message = message;

    }
}
