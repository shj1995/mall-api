package com.shj1995.mall.core.utils;

import java.util.UUID;

/**
 * @author 石豪杰
 * @date 2021/9/22 11:33
 */
public class UUIDUtils {
    public static String generator() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
