package com.shj1995.mall.product.controller.req;

import com.shj1995.mall.core.controller.req.BaseQueryReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shj
 * @date 2021/9/25 8:15 下午
 * @company 上海佳一智慧健康管理有限公司
 */
@ApiModel("商品查询参数")
@Data
public class ProductQueryReq extends BaseQueryReq {

    @ApiModelProperty("商品名称")
    private String name;
}
