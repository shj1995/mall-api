package com.shj1995.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;

/**
 * @author shj
 * @date 2021/9/21 9:08 下午
 */
@Configuration
@MapperScan("com.shj1995.mall.*.mapper")
public class MybatisConfig {
}
