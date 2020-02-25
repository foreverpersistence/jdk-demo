package com.fred.learning.juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-08
 * Desc     :  todo
 */
public class Test {

    public static void main(String[] args) {

        //原生 三大方法
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        ExecutorService threadPool2 = Executors.newCachedThreadPool();
        ExecutorService threadPool3 = Executors.newSingleThreadExecutor();

        try {

            //10 thread
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " running..");
                });
            }
        } catch (Exception e) {

        } finally {
            threadPool.shutdown();
        }
    }
}
