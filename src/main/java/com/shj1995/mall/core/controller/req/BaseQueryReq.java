package com.shj1995.mall.core.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shj
 * @date 2021/9/25 8:10 下午
 * @company 上海佳一智慧健康管理有限公司
 */

@ApiModel("查询参数")
@Data
public class BaseQueryReq {

    @ApiModelProperty("关键字查询")
    private String keyword;

    @ApiModelProperty(value = "页码")
    private Integer page = 1;

    @ApiModelProperty(value = "每页数量")
    private Integer size = 20;
}
