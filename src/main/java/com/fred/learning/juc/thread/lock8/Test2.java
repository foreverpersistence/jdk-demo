package com.fred.learning.juc.thread.lock8;

import java.util.concurrent.TimeUnit;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-13
 * Desc     : 2\ 邮件方法暂停4秒钟，请问先打印邮件还是短信？
 */
public class Test2 {

    public static void main(String[] args) {
        Phone2 phone = new Phone2();

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
class Phone2 {

    //被 synchronized 锁的方法，锁的对象是 方法的调用者
    public synchronized void sendEmail() {

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail");
    }

    public synchronized void sendMs() {


        System.out.println("sendMs");
    }
}
