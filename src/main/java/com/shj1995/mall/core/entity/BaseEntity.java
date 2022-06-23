package com.shj1995.mall.core.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建用户Id")
    private Long createUserId;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "更新用户Id")
    private Long updateUserId;

    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
}
