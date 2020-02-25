package com.fred.learning.juc.thread;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-12
 * Desc     :  3个 售票员， 卖 30 张票
 *      线程  操作 （）资源类
 */
public class SaleTicketTest1 {

    public static void main(String[] args) {

        SaleTicket saleTicket = new SaleTicket();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    saleTicket.saleTicket();
                }
            }
        }, "-A").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    saleTicket.saleTicket();
                }
            }
        }, "-B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    saleTicket.saleTicket();
                }
            }
        }, "-C").start();
    }

}

//资源类    高内聚
class SaleTicket {
    private int number = 30;

    public synchronized void saleTicket() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + " 卖出第 " + (number--) + " 张票");
        }
    }

}