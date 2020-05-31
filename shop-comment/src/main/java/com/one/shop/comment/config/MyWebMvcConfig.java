package com.one.shop.comment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    //default void addFormatters(FormatterRegistry registry) {}  //类型转换方法
    //default void addInterceptors(InterceptorRegistry registry) {}  //拦截器方法
    // default void addResourceHandlers(ResourceHandlerRegistry registry) {} //资源注册方法
    //default void addCorsMappings(CorsRegistry registry) {  //跨域访问方法
    //静态资源配置的方法
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //注册静态资源访问路径，以及路径指向的实际地址
        registry.addResourceHandler("/img/**").addResourceLocations("file:E:\\zhuanji\\实训一\\pic\\");
    }

    //跨域访问
   /* @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .maxAge(3600);
    }*/

}
