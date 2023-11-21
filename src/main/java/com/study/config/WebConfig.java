package com.study.config;

import com.study.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类：此处注册拦截器
 * 在Spring框架中，你可以通过实现HandlerInterceptor接口来创建一个拦截器。
 * 但是，仅仅实现了拦截器并不能让它工作，你还需要告诉Spring框架在处理哪些请求时需要使用这个拦截器，这就是注册拦截器的过程。
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 登录接口和注册接口不拦截
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login","/user/register");
    }
}
