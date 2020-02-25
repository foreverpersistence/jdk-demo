package com.fred.learning.jdk8.funtion;

import java.util.function.Predicate;

/**
 * @Author: xxx
 * @Date: 2020/2/23 下午12:02
 * @Description: todo
 */
public class PredicateDemo {

    public static void main(String[] args) {

        //一个参数，返回 boolean
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String o) {
//                if (o.equals("abc")) {
//                    return true;
//                }
//                return false;
//            }
//        };
        Predicate<String> predicate = s -> {
            return s.isEmpty();
        };
        System.out.println(predicate.test("abc"));
    }
}
