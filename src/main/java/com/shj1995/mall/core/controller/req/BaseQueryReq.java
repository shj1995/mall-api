package com.shj1995.mall.core.controller.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shj
 * @date 2021/9/25 8:10 下午
 * @company 上海佳一智慧健康管理有限公司
 */
@Data
public class BaseQueryReq {

    @ApiModelProperty(value = "页码")
    private int current;

    @ApiModelProperty(value = "每页数量")
    private int size;
}
