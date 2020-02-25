package com.fred.learning.jvm;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-17
 * Desc     :  todo
 */
public class Demo01 {
    public static void main(String[] args) {

        Object object = new Object();
        Demo01 demo01 = new Demo01();

        System.out.println(object.getClass().getClassLoader());//null 没有 或者 java 触及不到
        System.out.println(demo01.getClass().getClassLoader());//AppClassLoader
        System.out.println(demo01.getClass().getClassLoader().getParent());//ExtClassLoader
        System.out.println(demo01.getClass().getClassLoader().getParent().getParent());


        //JNI, 调用 native 方法
    }
}
