package com.shj1995.mall.system.entity;

import com.shj1995.mall.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 推荐栏目
 * </p>
 *
 * @author 石豪杰
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Recommend对象", description="推荐栏目")
public class Recommend extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "栏目代码")
    private String code;

    @ApiModelProperty(value = "栏目名称")
    private String name;

    @ApiModelProperty(value = "展示类型：1.轮播图，2.图标")
    private Integer showType;

    @ApiModelProperty(value = "最大展示数量")
    private Integer max;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "是否展示 1 是 0 否 ")
    private Boolean displayed;


}
