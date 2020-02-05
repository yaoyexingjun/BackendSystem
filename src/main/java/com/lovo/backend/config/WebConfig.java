package com.lovo.backend.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/page/**").addResourceLocations("classpath:/page/");
        registry.addResourceHandler("/admin/**").addResourceLocations("classpath:/admin/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/vue/**").addResourceLocations("classpath:/vue/");
        registry.addResourceHandler("/modules/**").addResourceLocations("classpath:/modules/");
        registry.addResourceHandler("/layuiadmin/**").addResourceLocations("classpath:/layuiadmin/");
    }
}
