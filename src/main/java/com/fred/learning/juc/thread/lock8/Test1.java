package com.fred.learning.juc.thread.lock8;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-13
 * Desc     :
 *       1、标准访问，请问先打印邮件还是短信？
 *
 */
public class Test1 {

    public static void main(String[] args) {

        Phone phone = new Phone();

        //使用同一个对象，两个线程是 1把锁。
        new Thread(() -> {
            phone.sendEmail();
        },"A").start();

        new Thread(() -> {
            phone.sendMs();
        },"B").start();
    }
}

//手机 发短信，打电话
class Phone {

    //被 synchronized 锁的方法，锁的对象是 方法的调用者
    public synchronized void sendEmail() {
        System.out.println("sendEmail");
    }

    public synchronized void sendMs() {
        System.out.println("sendMs");
    }
}
