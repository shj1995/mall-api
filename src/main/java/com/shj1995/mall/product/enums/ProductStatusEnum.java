package com.shj1995.mall.product.enums;

import com.shj1995.mall.core.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString()
public enum ProductStatusEnum implements BaseEnum {
    REMOVED(1, "已下架"),
    IN_STOCK(2, "在售"),
    SOLD_OUT(3, "已售完"),
    ;


    private final Integer code;
    private final String name;
}
