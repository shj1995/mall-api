package com.shj1995.mall.user.service;

import com.shj1995.mall.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-21
 */
public interface IUserService extends IService<User> {
    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    User getUserByUsername(String username);
}
