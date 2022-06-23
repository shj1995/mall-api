package com.shj1995.mall.core.enums;

public interface BaseEnum {

    static <T extends BaseEnum> T getEnumByCode(Class<T> tClass, Integer code) {
        T[] enumConstants = tClass.getEnumConstants();
        for (T e : enumConstants) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return null;
    }

    Integer getCode();

    String getName();
}
