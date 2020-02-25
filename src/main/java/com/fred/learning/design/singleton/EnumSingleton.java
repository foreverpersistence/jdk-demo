package com.fred.learning.design.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-19
 * Desc     :  枚举
 */
public enum  EnumSingleton {

    INSTANCE;

    public EnumSingleton getInstance() {
        return INSTANCE;
    }

}

class Demo2 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        EnumSingleton instance = EnumSingleton.INSTANCE;
        EnumSingleton instance1 = EnumSingleton.INSTANCE;

//        System.out.println(instance == instance1);

        //enum 是有参构造器
        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        declaredConstructor.newInstance();
    }
}
