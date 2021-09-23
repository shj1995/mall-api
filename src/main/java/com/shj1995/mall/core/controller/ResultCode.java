package com.shj1995.mall.core.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author shj
 * @date 2021/9/22 7:52 上午
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    /**
     *
     */
    SUCCESS("0","ok"),
    /**
     *
     */
    FAIL("-1","服务器异常"),
    ;
    private String code;
    private String message;
}
