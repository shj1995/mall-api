package com.shj1995.mall.user.controller;

import com.shj1995.mall.core.controller.Result;
import com.shj1995.mall.user.controller.req.UserLoginReq;
import com.shj1995.mall.user.security.JwtTokenUtil;
import com.shj1995.mall.user.security.JwtUserDetailsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Api(tags = "登录认证相关接口")
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsServiceImpl jwtUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    @ApiOperation(value = "登录状态", hidden = true)
    @RequestMapping("/login/{status}")
    public Result<Boolean> login(@PathVariable String status) {
        String message;
        if ("success".equals(status)) {
            return Result.ok(true);
        } else if (StringUtils.equals("auth", status)) {
            message = "未登录";
        } else if ("fail".equals(status)) {
            message = "登录失败";
        } else if ("logout".equals(status)) {
            message = "注销成功";
        } else {
            message = "系统错误";
        }
        return Result.fail(message);
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<String> login(@RequestBody UserLoginReq req) {
        try {
            UserDetails userDetail = this.jwtUserDetailsService.loadUserByUsername(req.getUsername());
            if (this.passwordEncoder.matches(req.getPassword(), userDetail.getPassword())) {
                String token = jwtTokenUtil.generateToken(userDetail);
                return Result.ok(token);
            }
            return Result.fail("用户名或密码不正确");
        } catch (UsernameNotFoundException e) {
            return Result.fail( "用户名或密码不正确");
        }
    }
}
