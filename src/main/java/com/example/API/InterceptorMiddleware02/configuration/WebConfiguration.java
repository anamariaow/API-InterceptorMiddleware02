package com.example.API.InterceptorMiddleware02.configuration;

import com.example.API.InterceptorMiddleware02.interceptors.MonthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    MonthInterceptor monthInterceptor;
//    @Override
    public void addInterceptor(InterceptorRegistry registry) {
        registry.addInterceptor(monthInterceptor).addPathPatterns("/months");
    }

}
