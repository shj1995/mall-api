package com.shj1995.mall.core.exception;

import com.shj1995.mall.core.controller.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerConfig {
    /**
     * 业务异常处理
     *
     * @param e 业务异常
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result<String> businessExceptionHandler(BusinessException e) {
        log.error("rest error", e);
        return Result.fail(e.getCode(), e.getErrorMsg());
    }

    /**
     * 业务异常处理
     *
     * @param e 业务异常
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> exceptionHandler(Exception e) {
        log.error("rest error", e);
        return Result.fail(ExceptionEnum.UNKNOWN.getCode(), ExceptionEnum.UNKNOWN.getMessage());
    }
}
