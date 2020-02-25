package com.fred.learning.juc.blocking;

import java.util.concurrent.SynchronousQueue;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-08
 * Desc     :  todo
 */
public class Test5 {

    public static void main(String[] args) {
        // 不用写参数
        SynchronousQueue<Object> queue = new SynchronousQueue<>();

        new Thread(() -> {
            try {

                queue.put(1);
            } catch (Exception e) {

            }
        },"A").start();

        new Thread(()-> {

            try {
//                Thread.sleep(3, TimeUnit.SECONDS);
                queue.take();
                queue.take();
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
