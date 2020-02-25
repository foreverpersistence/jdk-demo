package com.fred.learning.jdk8.funtion;

import java.util.function.Consumer;

/**
 * @Author: xxx
 * @Date: 2020/2/23 下午12:05
 * @Description: todo
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        // 没有返回值，只能 传递参数
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println("o");
//            }
//        };

        Consumer<String> consumer = s -> {
            System.out.println(s);
        };
        consumer.accept("133");

        // 供给型 接口， 只有返回值，没有参数。 生产者
    }
}
