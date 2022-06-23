package com.shj1995.mall.core.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("枚举对象")
public class EnumEntity {

    @ApiModelProperty("代码")
    private final Integer code;
    @ApiModelProperty("名称")
    private final String name;

    public EnumEntity(BaseEnum baseEnum) {
        this.code = baseEnum.getCode();
        this.name = baseEnum.getName();
    }

    public static EnumEntity valueOf(BaseEnum baseEnum) {
        return new EnumEntity(baseEnum);
    }

}
