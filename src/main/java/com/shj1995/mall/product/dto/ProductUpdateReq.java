package com.shj1995.mall.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author shj
 * @date 2021/9/25 8:30 下午
 * @company 上海佳一智慧健康管理有限公司
 */
@Data
@ApiModel("商品更新的请求体")
public class ProductUpdateReq {

    @ApiModelProperty(value = "id", required = true)
    private Long id;

    @ApiModelProperty(value = "商品名称", required = true)
    private String name;

    @ApiModelProperty(value = "商品封面图片", required = true)
    private String coverImage;

    @ApiModelProperty(value = "商品详细图片", required = true)
    private String detailImages;

    @ApiModelProperty(value = "简介", required = true)
    private String introduction;

    @ApiModelProperty(value = "详情描述", required = true)
    private String description;

    @ApiModelProperty(value = "价格", required = true)
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "商品分类", required = true)
    private Long typeId;

    @ApiModelProperty(value = "是否在售 1 是 0 否 ", required = true)
    private Boolean sale;

    @ApiModelProperty(value = "销售数量")
    private Integer saleQuantity;

    @ApiModelProperty(value = "库存数量")
    private Integer inventoryQuantity;

    @ApiModelProperty(value = "快递模板ID ")
    private Long expressTemplateId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "是否新品", required = true)
    private Boolean newProduct;
}
