package com.fred.learning.juc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-12
 * Desc     :  Lock
 */
public class SaleTicketTest2 {

    public static void main(String[] args) {

        SaleTicket2 saleTicket = new SaleTicket2();

        // lambda， () -> {}
        // 链式编程，
        // 流失计算
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                saleTicket.saleTicket();
            }
        }, "-A").start();


        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                saleTicket.saleTicket();
            }
        }, "-B").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                saleTicket.saleTicket();
            }
        }, "-C").start();
    }

}

//资源类    高内聚
class SaleTicket2 {
    private int number = 30;

    //Lock
    private Lock lock = new ReentrantLock();

    public void saleTicket() {
        lock.lock();
        try {

            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖出第 " + (number--) + " 张票");
            }
        } catch (Exception e) {

        }finally {
            lock.unlock();
        }
    }

}