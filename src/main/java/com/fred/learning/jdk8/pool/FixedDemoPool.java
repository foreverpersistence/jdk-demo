package com.fred.learning.jdk8.pool;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2019-12-26
 * Desc     :  todo
 */
public class FixedDemoPool {

    private LinkedBlockingQueue queue;//任务池
    private List<Thread> workers;



    //任务
    public static class Worker extends Thread {
        @Override
        public void run() {
            //从 queue 中获取 task，执行


        }
    }


    //





}
