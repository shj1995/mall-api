package com.shj1995.mall.user.system.auth;

import lombok.Data;

@Data
public class Role {
    private Long id;
    private String name;
    private String description;

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }
}
