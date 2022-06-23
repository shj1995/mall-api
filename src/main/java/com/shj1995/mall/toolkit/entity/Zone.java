package com.shj1995.mall.toolkit.entity;

import com.shj1995.mall.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author 石豪杰
 * @since 2022-06-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Zone对象", description="")
public class Zone extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "地区代码")
    private String code;

    @ApiModelProperty(value = "地区名称")
    private String name;

    @ApiModelProperty(value = "上级ID")
    private Long parentId;

    @ApiModelProperty(value = "级别")
    private Long level;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "创建用户id")
    private Long createUserId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改用户id")
    private Long updateUserId;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


}
