package com.springboot.config;

import com.springboot.interceptor.APIInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// MVC配置使http://IP:端口号/${server.context-path}/profile/图片路径可以访问到配置的文件夹
@Configuration
@EnableConfigurationProperties({AppConfig.class})
public class WebAppConfig implements WebMvcConfigurer {

    //图片保存路径
    public static final String PIC_PATH = "/profile/";
    @Autowired
    private AppConfig appConfig;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /** 图片传路径 */
        registry.addResourceHandler("/profile/**").addResourceLocations("file:" + this.appConfig.getProfile());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加api拦截器
        registry.addInterceptor(new APIInterceptor()).addPathPatterns("/api/**");
    }
}
