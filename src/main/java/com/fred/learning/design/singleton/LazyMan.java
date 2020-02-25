package com.fred.learning.design.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-19
 * Desc     :  懒汉式 不安全。 主要通过私有变量，都可以 都过反射破解
 */
public class LazyMan {

    //指令重拍，不是 原子性操作
    //1、分配内存
    //2、执行构造方法
    //3、指向地址

    private static boolean flag = false;

    public volatile static LazyMan instance;
    private LazyMan() {
        if (!flag){
            flag = true;
        } else {
            throw new RuntimeException("反射破坏单粒模式");
        }
//        synchronized (LazyMan.class) {
//            if (instance != null) {
//                throw new RuntimeException("反射破坏单粒模式");
//            }
//        }

    }

    public static LazyMan getInstance() {
        if (instance == null) {
            synchronized (LazyMan.class) {
                if (instance == null) {
                    instance = new LazyMan();
                }
            }
        }
        return instance;
    }
}

class Demo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
//        LazyMan instance = LazyMan.getInstance();
        //反射

        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        LazyMan lazyMan = declaredConstructor.newInstance();

        Field flag = lazyMan.getClass().getDeclaredField("flag");
        flag.setAccessible(true);
        flag.set(lazyMan, false);

        LazyMan lazyMan1 = declaredConstructor.newInstance();
//        System.out.println(instance == lazyMan);
        System.out.println(lazyMan1 == lazyMan);


    }
}