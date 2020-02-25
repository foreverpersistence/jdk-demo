package com.fred.learning.jdk8.funtion;

import java.util.function.Supplier;

/**
 * @Author: xxx
 * @Date: 2020/2/23 下午12:07
 * @Description: 供给型接口
 */
public class SupplierDemo {

    public static void main(String[] args) {

//        Supplier<String> supplier = new Supplier() {
//            @Override
//            public Object get() {
//
//                return "success";
//            }
//        };

        Supplier<String> supplier = () -> {
            return "success";
        };
        System.out.println(supplier.get());
    }
}
