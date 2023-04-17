package com.gpt.example.practice.global.common.dto;

import com.gpt.example.practice.global.exception.ErrorCode;

public record ErrorResponse(
        String code,
        String message) {
    public static ErrorResponse of(ErrorCode code) {
        return new ErrorResponse(code.getCode(), code.getMessage());
    }
}
