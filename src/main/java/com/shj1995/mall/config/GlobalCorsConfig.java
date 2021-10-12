package com.shj1995.mall.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class GlobalCorsConfig implements WebMvcConfigurer {

    private static final long MAX_AGE = 18000L;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .maxAge(MAX_AGE);

    }
}