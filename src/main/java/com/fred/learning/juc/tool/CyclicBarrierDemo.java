package com.fred.learning.juc.tool;

import java.util.concurrent.CyclicBarrier;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-16
 * Desc     :  栏栅， 加法器
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        //达到要求后，执行 runnable
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {

            System.out.println("3456");
        });

        for (int i = 0; i < 7; i++) {
            final  int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "手机了第"+temp + " 颗龙珠");

                try {
                    cyclicBarrier.await();
                }catch (Exception e) {

                }
            }).start();
        }

    }
}
