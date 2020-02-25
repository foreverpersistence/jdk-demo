package com.fred.learning.juc.thread.lock8;

import java.util.concurrent.TimeUnit;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-13
 * Desc     :  3、 新增普通方法
 */
public class Test3 {


    public static void main(String[] args) {
        Phone3 phone = new Phone3();

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
            phone.hello();
        },"C").start();
    }
}

//手机 发短信，打电话
class Phone3 {

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

    //没有 锁， 不是同步方法。 执行和锁无关
    public void hello() {
        System.out.println("hello");
    }
}
