package com.shj1995.mall.core.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.shj1995.mall.user.security.SecurityUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Long userId = getUserId();
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "createUserId", Long.class, userId);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Long userId = getUserId();

        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        // 或者
        this.strictUpdateFill(metaObject, "updateUserId", Long.class, userId);
    }

    private Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof SecurityUserDetails) {
            SecurityUserDetails userDetails = (SecurityUserDetails) principal;
            return userDetails.getId();
        }
        return null;
    }
}
