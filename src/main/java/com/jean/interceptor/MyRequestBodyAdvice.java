package com.jean.interceptor;

import com.jean.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;

@ControllerAdvice
public class MyRequestBodyAdvice extends RequestBodyAdviceAdapter {

    private final HttpServletRequest httpServletRequest;

    private final LogService logService;

    @Autowired
    public MyRequestBodyAdvice(HttpServletRequest httpServletRequest, LogService logService) {
        this.httpServletRequest = httpServletRequest;
        this.logService = logService;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type type,
            Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
            Class<? extends HttpMessageConverter<?>> converterType) {
        logService.saveRequest(httpServletRequest, body);

        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }
}
