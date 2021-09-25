package com.shj1995.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
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
@ApiModel(value="Type对象", description="商品分类")
public class Type extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品分类名称")
    private String name;

    @ApiModelProperty(value = "创建用户id")
    private Long createUserId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改用户id")
    private Long updateUserId;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


}
