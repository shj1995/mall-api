package com.shj1995.mall.user.security;

import cn.hutool.core.bean.BeanUtil;
import com.shj1995.mall.user.entity.User;
import com.shj1995.mall.user.system.auth.Role;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityUserDetails extends User implements UserDetails {

    @Getter
    private List<GrantedAuthority> rules = new ArrayList<>();

    public SecurityUserDetails(User user, List<Role> roles) {
        BeanUtil.copyProperties(user, this);
        for (Role role : roles) {
            this.rules.add(new SimpleGrantedAuthority("ROLE_" + role.getId()));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.rules;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.getEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.getLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
