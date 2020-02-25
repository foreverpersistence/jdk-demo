package com.fred.learning.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-14
 * Desc     :  todo
 */
public class Test1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        // Thread（Runnable）
        // Thread（RunnableFuture）
        // Thread（FutureTask）

        MyThread myThread = new MyThread();
        FutureTask task = new FutureTask(myThread); // 适配类

        // 会打印几次 end
        new Thread(task,"A").start(); // 执行线程
        new Thread(task,"B").start(); // 执行线程。细节1：结果缓存！效率提高N倍

        System.out.println(task.get());// 获取返回值， get()

        // 细节2：task.get() 获取值的方法一般放到最后，保证程序平稳运行的效率，因为他会阻塞等待结果产生！
        // 线程是一个耗时的线程，不重要！

    }
}



class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("end");
        return 1024;
    }
}
