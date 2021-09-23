package com.shj1995.mall.core.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 石豪杰
 * @date 2021/9/22 10:57
 */
@Data
public class BaseEntity implements Serializable {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "逻辑删除 1 是 0 否 ")
    private Boolean deleted;

    @ApiModelProperty(value = "创建用户Id")
    private Long createUserId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新用户Id")
    private Long updateUserId;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
}
