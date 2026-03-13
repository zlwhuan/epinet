package com.clzk.epinet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                  // 允许所有路径
                .allowedOrigins("*")                // 允许所有来源（*）
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "PATCH")  // 允许的请求方法
                .allowedHeaders("*")                // 允许所有请求头
                .allowCredentials(false)            // 允许携带 cookie 时必须设为 false（* 和 credentials 不能同时用）
                .maxAge(3600);                      // 预检请求缓存时间（秒）
    }
}