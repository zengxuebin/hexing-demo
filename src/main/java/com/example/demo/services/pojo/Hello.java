package com.example.demo.services.pojo;

/**
 * @author CaoLongHui
 * @since 2024/6/29 12:51
 */
public class Hello {

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
