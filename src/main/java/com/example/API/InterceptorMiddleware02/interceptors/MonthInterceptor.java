package com.example.API.InterceptorMiddleware02.interceptors;

import com.example.API.InterceptorMiddleware02.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    private static List<Month> months = Arrays.asList(
            new Month(1, "January", "Gennaio", "Januar"),
            new Month(2, "February", "Febbraio", "Februar"),
            new Month(3, "March", "Marzo", "März"),
            new Month(4, "April", "Aprile", "April"),
            new Month(5, "May", "Maggio", "Mai"),
            new Month(6, "June", "Giugno", "Juni")
    );

    public static Month getMonth(Integer monthNumber) {
        if (monthNumber == null) {
            throw new IllegalArgumentException("Month number cannot be null");
        }
        for (Month month : months) {
            if (month.getMonthNumber() == monthNumber) {
                return month;
            }
        }
        return new Month(monthNumber, "nope", "nope", "nope");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberHeader = request.getHeader("monthNumber");
        if (monthNumberHeader == null || monthNumberHeader.isEmpty()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return false;
        }
        return true;
    }

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        String monthNumberHeader = request.getHeader("monthNumber");
//        if (StringUtils.isEmpty(monthNumberHeader)) {
//            response.setStatus(HttpStatus.BAD_REQUEST.value());
//            return false;
//        }
//
//        int monthNumber = Integer.parseInt(monthNumberHeader);
//        Month matchingMonth = months.stream()
//                .filter(month -> month.getMonthNumber() == monthNumber)
//                .findFirst()
//                .orElseGet(() -> new Month(0, "nope", "nope", "nope"));
//
//        request.setAttribute("month", matchingMonth);
//        return true;
//    }
}
