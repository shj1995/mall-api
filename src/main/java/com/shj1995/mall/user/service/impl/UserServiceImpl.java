package com.shj1995.mall.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.shj1995.mall.user.entity.User;
import com.shj1995.mall.user.mapper.UserMapper;
import com.shj1995.mall.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author 石豪杰
 * @since 2021-09-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User getUserByUsername(String username) {
        return this.getOne(Wrappers.<User>lambdaQuery()
                .eq(User::getUsername,username)
        );
    }
}
