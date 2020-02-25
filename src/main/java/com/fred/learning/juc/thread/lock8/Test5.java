package com.fred.learning.juc.thread.lock8;

import java.util.concurrent.TimeUnit;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-13
 * Desc     :  5、两个静态同步方法，同一部手机，请问先打印邮件还是短信？**
 */
public class Test5 {

    public static void main(String[] args) {
        Phone5 phone = new Phone5();
        //两把锁， 两个方法调用没有关系

        //使用同一个对象，两个线程是 1把锁。
        new Thread(() -> {
            phone.sendEmail();
        },"A").start();

        //干扰
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone.sendMs();
        },"C").start();
    }

}

//手机 发短信，打电话
class Phone5 {

    //对象： 可以 new 多个对象
    //Class 类模版，只有一个

    //被 synchronized 锁的方法，锁的对象是 方法的调用者
    //被 synchronized 和 static 修饰的方法，锁的对象是  类的 class对象
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
