package com.shj1995.mall.user.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.shj1995.mall.core.controller.BaseRDController;
import com.shj1995.mall.user.entity.User;
import com.shj1995.mall.user.service.IUserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-21
 */
@Api(tags = "用户")
@RestController
@RequestMapping("/user/user")
@RequiredArgsConstructor
public class UserController extends BaseRDController<User> {

    private final IUserService userService;

    @Override
    public IService<User> service() {
        return this.userService;
    }
}

