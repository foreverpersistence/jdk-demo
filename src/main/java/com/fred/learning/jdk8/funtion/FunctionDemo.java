package com.fred.learning.jdk8.funtion;

import java.util.function.Function;

/**
 * @Author: xxx
 * @Date: 2020/2/23 上午11:56
 * @Description: todo
 */
public class FunctionDemo {
    public static void main(String[] args) {

        // 传入 String， 返回 Integer
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String o) {
                return 1024;
            }
        };

        // 链式编程，流失计算，lambada 表达式
        Function<String,Integer> function1 = s -> {return  s.length();};
        System.out.println(function1.apply("abc"));

    }
}
