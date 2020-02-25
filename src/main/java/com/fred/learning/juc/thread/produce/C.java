package com.fred.learning.juc.thread.produce;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-13
 * Desc     :  线程 A B C
 *      三个线程 依次打印
 *      A- 5
 *      B-10
 *      C-15
 *
 *      精确通知线程消费
 */
public class C {
}


//资源类-- 精确配置
class Data3 {
    private int num = 0; // 计数器
    //锁
    Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    public void print5() throws InterruptedException {
        lock.lock();
        try {

            //判断条件
            while (num != 0) {
                condition1.await();
            }

            //干活
            System.out.println(Thread.currentThread().getName() + ", " + num);

            //修改条件
            num = 1;

            //通知2
            condition2.signal();
        } catch (Exception e) {

        }finally {
            lock.unlock();
        }
    }


    }