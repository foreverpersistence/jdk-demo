package com.fred.learning.design.singleton;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-19
 * Desc     :  恶汉式
 */
public class Hungry {

    private static final Hungry instance = new Hungry();

    //浪费
    private byte[] data = new byte[1024];
    private byte[] data2 = new byte[1024];
    private byte[] data3 = new byte[1024];
    private Hungry(){

    }


    public static Hungry getInstance() {
        return instance;
    }


}
