package com.fred.learning.juc.thread.lock8;

import java.util.concurrent.TimeUnit;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-13
 * Desc     :  7、一个普通同步方法，一个静态同步方法，同一部手机，请问先打印邮件还是短信？**
 */
public class Test7 {

    public static void main(String[] args) {
        Phone7 phone = new Phone7();
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
class Phone7 {

    //被 synchronized 锁的方法，锁的对象是 方法的调用者
    public static synchronized void sendEmail() {

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail");
    }


    //对象
    //普通同步方法
    public synchronized void sendMs() {

        System.out.println("sendMs");
    }

}
