package com.shj1995.mall.core.controller;

import lombok.Data;

/**
 * @author shj
 * @date 2021/9/21 8:18 下午
 * @company 上海佳一智慧健康管理有限公司
 */
@Data
public class Result<T> {
    private String code;
    private String message;
    private T data;

    public static <T> Result<T> ok(T data){
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }
    public static <T> Result<T> fail(String message){
        Result<T> result = new Result<>();
        result.setCode(ResultCode.FAIL.getCode());
        result.setMessage(message);
        return result;
    }
}
