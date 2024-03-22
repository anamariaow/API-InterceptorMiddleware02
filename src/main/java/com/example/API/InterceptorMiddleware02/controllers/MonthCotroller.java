package com.example.API.InterceptorMiddleware02.controllers;

import com.example.API.InterceptorMiddleware02.entities.Month;
import com.example.API.InterceptorMiddleware02.interceptors.MonthInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/month")
public class MonthCotroller {

    @GetMapping
    public Month getMonth(Integer monthNumber) {
        Month month = MonthInterceptor.getMonth(monthNumber);
        return month;
    }
}
