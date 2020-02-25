package com.fred.learning.juc.blocking;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-08
 * Desc     :  blockingQueue@ offer\ poll 返回特殊值
 */
public class Test2 {

    public static void main(String[] args) {

        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // false
        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.peek());//查看队首

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());//null

    }
}
