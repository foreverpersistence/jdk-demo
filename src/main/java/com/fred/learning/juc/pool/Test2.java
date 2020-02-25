package com.fred.learning.juc.pool;

import java.util.concurrent.*;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-08
 * Desc     :
 *
 */
public class Test2 {

    public static void main(String[] args) {

        //代码级别设置 核心数 Runtime.getRuntime().availableProcessors()
//        System.out.printf("", Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(
                        2,
                        Runtime.getRuntime().availableProcessors(),//线程池 最大大小 5
                        2L, //超时回收线程
                        TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(3),//队列, 根据业务，大小必须要设置，防止 OOM
                        Executors.defaultThreadFactory(),// 不变
                        new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略

        //拒绝策略
        //AbortPolicy 默认，队列满了，丢弃任务，抛出异常
        //CallerRunsPolicy 哪来的，就哪里处理
        //DiscatdOldestPolicy  尝试 将最早进入队列的任务删除 尝试 加入队列
        //DiscardPolicy 队列满了，不抛出异常，任务会丢弃

        try {

            //模拟银行办理业务
            for (int i = 0; i < 20; i++) {
                threadPool.execute(() -> {

                    System.out.println(Thread.currentThread().getName() + "runing...");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
