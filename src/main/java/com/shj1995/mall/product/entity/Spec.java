package com.shj1995.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shj1995.mall.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * <p>
 * 商品规格
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("product_spec")
@ApiModel(value="Spec对象", description="商品规格")
public class Spec extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品ID")
    private Long productId;

    @ApiModelProperty(value = "规格名称")
    private String name;

    @ApiModelProperty(value = "商品图片")
    private String imageIds;

    @ApiModelProperty(value = "说明")
    private String description;

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

}
