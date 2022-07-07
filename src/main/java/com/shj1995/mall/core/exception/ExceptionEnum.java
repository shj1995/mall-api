package com.shj1995.mall.core.exception;

import lombok.Getter;

@Getter
public enum ExceptionEnum {
    UNKNOWN("10000", "服务器内部错误!"),
    IS_NOT_NULL("10001", "%s不能为空");

    private final String code;
    private final String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
