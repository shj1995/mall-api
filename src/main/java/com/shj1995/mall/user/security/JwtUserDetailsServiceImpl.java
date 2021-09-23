package com.shj1995.mall.user.security;

import com.shj1995.mall.user.entity.User;
import com.shj1995.mall.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author shj
 * @date 2021/9/21 8:15 下午
 */
@Service("JwtUserDetailsService")
@RequiredArgsConstructor
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private final IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userService.getUserByUsername(username);

        return new SecurityUserDetails(user, Collections.emptyList());
    }
}
