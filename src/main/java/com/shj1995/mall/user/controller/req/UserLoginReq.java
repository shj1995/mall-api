package com.shj1995.mall.user.controller.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shj
 * @date 2021/9/22 7:58 上午
 * @company 上海佳一智慧健康管理有限公司
 */
@Data
public class UserLoginReq {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;
}
