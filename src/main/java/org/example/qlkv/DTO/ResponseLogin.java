package org.example.qlkv.DTO;

import lombok.Data;

@Data
public class ResponseLogin <T>{
    private T data;
    private String message;
    private String token;

    public ResponseLogin(String message, T data,String token) {
        this.data = data;
        this.message = message;
        this.token = token;
    }
}
