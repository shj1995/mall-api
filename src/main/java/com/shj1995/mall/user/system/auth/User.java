package com.shj1995.mall.user.system.auth;

import com.google.common.collect.Sets;
import lombok.Data;

import java.util.Collection;

/**
 * @author shj
 * @date 2021/9/21 8:27 下午
 */
@Data
public class User {

    private String username;
    private String nickname;
    private String phone;
    private String email;
    private String password;
    private String personId;
    private String avatar;

    private Collection<Role> roles = Sets.newHashSet();
    private boolean enabled = true;
    private boolean expired = true;
    private boolean locked = true;
}
