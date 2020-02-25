package com.fred.learning.jdk8.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: xxx
 * @Date: 2020/2/23 下午9:41
 * @Description: todo
 * AtomicReference 原子引用
 *
 */
public class RefrenceDemo {

//    static AtomicReference atomicReference = new AtomicReference(100);
    static AtomicStampedReference atomicReference = new AtomicStampedReference(100, 1);
    public static void main(String[] args) {

        new Thread(() -> {
//            atomicReference.compareAndSet(100,101);
//            atomicReference.compareAndSet(101,100);
            //1、获得版本号
            int stamp = atomicReference.getStamp();
            System.out.println("T1 get stam 01=>" + stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicReference.compareAndSet(100,101, atomicReference.getStamp(),  atomicReference.getStamp()+ 1);
            atomicReference.compareAndSet(101,100,atomicReference.getStamp(), atomicReference.getStamp()+1);
        },"T1").start();


        new Thread(() -> {

            //1、获得版本号
            int stamp = atomicReference.getStamp();
            System.out.println("T2 get stam 01=>" + stamp);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = atomicReference.compareAndSet(100, 2020, stamp, stamp + 1);
            System.out.println("update success? " + b);
            System.out.println("stamp =>" + atomicReference.getStamp());
            System.out.println(atomicReference.getReference());
        },"T2").start();

    }
}
