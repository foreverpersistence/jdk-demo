package com.fred.learning.jdk8.atomic;

import com.fred.learning.juc.thread.produce.A;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xxx
 * @Date: 2020/2/23 下午9:22
 * @Description: todo
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        // compareAndSet(int expect, int update)
        System.out.println(atomicInteger.compareAndSet(5, 2020) +"=>" + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 1024) +"=>" + atomicInteger.get());


    }
}
