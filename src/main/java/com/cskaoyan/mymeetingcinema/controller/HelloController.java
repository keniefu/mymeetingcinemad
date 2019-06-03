package com.cskaoyan.mymeetingcinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HelloController {
    @RequestMapping("hello")
    @ResponseBody
    public String sayHello() {
        return "hello";
    }
}
