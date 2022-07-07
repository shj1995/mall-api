package com.shj1995.mall.system.entity;

import com.shj1995.mall.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 推荐项
 * </p>
 *
 * @author 石豪杰
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="RecommendItem对象", description="推荐项")
public class RecommendItem extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "推荐位ID")
    private Long recommendId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "图片或者图标")
    private String image;

    @ApiModelProperty(value = "跳转类型")
    private Integer type;

    @ApiModelProperty(value = "链接")
    private String href;

    @ApiModelProperty(value = "排序")
    private Integer sort;


}
