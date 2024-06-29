package com.example.demo.services;

import com.example.demo.services.pojo.Hello;
import org.springframework.stereotype.Component;

/**
 * @author CaoLongHui
 * @since 2024/6/29 12:50
 */
@Component
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String say(String str) {
        Hello hello = new Hello();
        hello.setStr(str);
        return hello.toString();
    }
}
