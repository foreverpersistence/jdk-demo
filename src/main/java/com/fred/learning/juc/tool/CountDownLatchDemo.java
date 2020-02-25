package com.fred.learning.juc.tool;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-14
 * Desc     :  todo
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {


    }

    public void test1() {
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {

            }).start();
        }
    }
}
