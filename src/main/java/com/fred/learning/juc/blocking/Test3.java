package com.fred.learning.juc.blocking;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-08
 * Desc     :  blockingQueue@ 一直阻塞
 */
public class Test3 {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        // false
//        blockingQueue.put("d");

        System.out.println(blockingQueue.peek());//查看队首
        
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());//
        System.out.println(blockingQueue.take());//

    }
}
