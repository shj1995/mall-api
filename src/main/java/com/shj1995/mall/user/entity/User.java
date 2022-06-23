package com.shj1995.mall.user.entity;

import com.shj1995.mall.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象", description="用户")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "密码",hidden = true)
    private String password;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "是否锁定  1 是 0 否")
    private Boolean locked;

    @ApiModelProperty(value = "是否启用  1 是 0 否 ")
    private Boolean enabled;

    @ApiModelProperty(value = "最后登录时间")
    private LocalDateTime lastLoginTime;


}
