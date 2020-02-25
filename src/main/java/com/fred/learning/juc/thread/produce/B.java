package com.fred.learning.juc.thread.produce;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-13
 * Desc     :  Lock Condition  生产者 消费者
 */
public class B {

    public static void main(String[] args) {

        Data2 data = new Data2();

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }

}

//资源类
class Data2 {
    private int num = 0;
    //锁
    Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void increment() throws InterruptedException {
        lock.lock();
        try {

            //判断
            while (num != 0) {
                condition.await();
            }

            //干活
            num++;
            System.out.println(Thread.currentThread().getName() + ", " + num);

            //通知
            condition.signalAll();
        } catch (Exception e) {

        }finally {
            lock.unlock();
        }
    }

    public  void  decrement() throws InterruptedException {
        lock.lock();
        try {

            //判断
            //        if (num==0) {
            //            this.wait();
            //        }
            while (num == 0) {
                condition.await();
            }
            //干活
            num--;

            System.out.println(Thread.currentThread().getName() + ", " + num);
            //通知
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}
