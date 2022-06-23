package com.shj1995.mall.product.entity;

import com.shj1995.mall.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Product对象", description = "商品")
public class Product extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品名称", required = true)
    private String name;

    @ApiModelProperty(value = "商品封面图片", required = true)
    private String coverImage;

    @ApiModelProperty(value = "商品详细图片", required = true)
    private String detailImages;

    @ApiModelProperty(value = "简介")
    private String introduction;

    @ApiModelProperty(value = "详情描述")
    private String description;

    @ApiModelProperty(value = "价格", required = true)
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "商品分类")
    private Long typeId;

    @ApiModelProperty(value = "是否在售 1 是 0 否 ")
    private Boolean sale;

    @ApiModelProperty(value = "销售数量")
    private Integer saleQuantity;

    @ApiModelProperty(value = "库存数量")
    private Integer inventoryQuantity;

    @ApiModelProperty(value = "快递模板ID")
    private Long expressTemplateId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "是否新品")
    private Boolean newProduct;
//
//    @ApiModelProperty(value = "商品状态")
//    private Integer status;

}
