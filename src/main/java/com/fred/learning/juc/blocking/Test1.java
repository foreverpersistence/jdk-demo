package com.fred.learning.juc.blocking;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-08
 * Desc     :  blockingQueue@ add\ remove 抛异常
 */
public class Test1 {

    public static void main(String[] args) {

        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        // java.lang.IllegalStateException: Queue full
//        System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

    }
}
