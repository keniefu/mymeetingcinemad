package com.cskaoyan.mymeetingcinema.handler;

import com.cskaoyan.mymeetingcinema.model.result.ExceptionResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ExceptionResult exceptionHandler(Exception e) {
        return new ExceptionResult(999, "系统出现异常，请联系管理员");
    }
}
