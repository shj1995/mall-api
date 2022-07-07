package com.shj1995.mall.core.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final String code;
    private final String errorMsg;
    private ExceptionEnum exceptionEnum;

    public BusinessException(String code, String errorMsg, Object... args) {
        super("{code:" + code + ",errorMsg:" + String.format(errorMsg, args) + "}");
        this.code = code;
        this.errorMsg = String.format(errorMsg, args);
    }

    public BusinessException(ExceptionEnum exceptionEnum, Object... args) {
        super("{code:" + exceptionEnum.getCode() + ",errorMsg:" + String.format(exceptionEnum.getMessage(), args) + "}");
        this.exceptionEnum = exceptionEnum;
        this.code = exceptionEnum.getCode();
        this.errorMsg = String.format(exceptionEnum.getMessage(), args);
    }
}
