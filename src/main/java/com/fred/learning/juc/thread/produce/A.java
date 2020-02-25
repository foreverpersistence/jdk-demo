package com.fred.learning.juc.thread.produce;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-12
 * Desc     :
 *       题目：现在两个线程，操作一个初始值为0的变量
 *  *       一个线程 + 1， 一个线程 -1。判断什么时候+1，什么时候-1
 *  *       交替10 次
 *
 */
public class A {

    public static void main(String[] args) {
        Data data = new Data();

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
class Data {
    private int num = 0;

    public synchronized void increment() throws InterruptedException {
        //判断
        //if 虚假唤醒
//        if (num != 0) {
//            this.wait();
//        }
        while (num != 0){
            this.wait();
        }

        //干活
        num++;
        System.out.println(Thread.currentThread().getName()+", " + num);

        //通知
        this.notifyAll();
    }

    public synchronized  void  decrement() throws InterruptedException {
        //判断
//        if (num==0) {
//            this.wait();
//        }
        while (num==0) {
            this.wait();
        }
        //干活
        num--;

        System.out.println(Thread.currentThread().getName()+", " + num);
        //通知
        this.notifyAll();

    }
}
