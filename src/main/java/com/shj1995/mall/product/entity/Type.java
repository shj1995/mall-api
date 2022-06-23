package com.shj1995.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shj1995.mall.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品分类
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("product_type")
@ApiModel(value = "Type对象", description = "商品分类")
public class Type extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品分类名称")
    private String name;

    @ApiModelProperty(value = "分类等级")
    private String level;

    @ApiModelProperty(value = "分类等级")
    private String parentId;

    @ApiModelProperty(value = "下级分类集合")
    @TableField(exist = false)
    private String children;


}
