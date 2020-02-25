package com.fred.learning.juc.thread.lock8;

import java.util.concurrent.TimeUnit;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-13
 * Desc     :  6、两个静态同步方法，2部手机，请问先打印邮件还是短信？**
 */
public class Test6 {

    public static void main(String[] args) {
        Phone6 phone1 = new Phone6();
        Phone6 phone2 = new Phone6();
        //两把锁， 两个方法调用没有关系

        //使用同一个对象，两个线程是 1把锁。
        new Thread(() -> {
            phone1.sendEmail();
        },"A").start();

        //干扰
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.sendMs();
        },"C").start();
    }
}

//手机 发短信，打电话
class Phone6 {

    //被 synchronized 锁的方法，锁的对象是 方法的调用者
    public static synchronized void sendEmail() {

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail");
    }

    public static synchronized void sendMs() {

        System.out.println("sendMs");
    }

}
