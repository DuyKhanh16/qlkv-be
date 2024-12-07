package org.example.qlkv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.Getter;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION("9999", "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY("1001", "Uncategorized error", HttpStatus.BAD_REQUEST),
    INVALID_USERNAME("1003", "Username must be at least {min} characters", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD("1004", "Password must be at least {min} characters", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED("1006", "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED("1007", "You do not have permission", HttpStatus.FORBIDDEN),
    EMAIL_EXISTED("1008", "Email existed, please choose another one", HttpStatus.BAD_REQUEST),
    USER_EXISTED("1009", "Username existed, please choose another one", HttpStatus.BAD_REQUEST),
    USERNAME_IS_MISSING("1010", "Please enter username", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED("1011", "User not existed", HttpStatus.BAD_REQUEST),

    ;

    ErrorCode(String code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final String code;
    private final HttpStatusCode statusCode;
    private final String message;
}