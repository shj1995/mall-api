package com.shj1995.mall.product.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.shj1995.mall.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@ApiModel(value="Product对象", description="商品")
public class Product extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品图片")
    private String imageIds;

    @ApiModelProperty(value = "简介")
    private String introduction;

    @ApiModelProperty(value = "详情描述")
    private String description;

    @ApiModelProperty(value = "价格")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "商品分类")
    private Long typeId;

    @ApiModelProperty(value = "是否在售 1 是 0 否 ")
    private Boolean sale;

    @ApiModelProperty(value = "创建用户id")
    private Long createUserId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改用户id")
    private Long updateUserId;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


}
