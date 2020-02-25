package com.fred.learning.juc.tool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-16
 * Desc     :  抢车位
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 6个车，只有3个车位

        Semaphore semaphore = new Semaphore(3);//3个车位
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                //得到车位
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 抢到车位");

                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + " 离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
