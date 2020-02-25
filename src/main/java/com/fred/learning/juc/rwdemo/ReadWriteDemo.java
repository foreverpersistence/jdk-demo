package com.fred.learning.juc.rwdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-08
 * Desc     : 读写锁。  读写分离，提高效率。
 *     判断 业务中 哪些是只读的
 */
public class ReadWriteDemo {

    public static void main(String[] args) {


        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(() -> {
                myCache.put(tmp+"", tmp+"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(() -> {
                myCache.get(tmp+"");
            },String.valueOf(i)).start();
        }


    }
}

//线程操作资源类
class MyCache2 {

    private volatile Map<String, Object> map = new HashMap<>();

    //读写所
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, String value) {
        //lock.lock()
        readWriteLock.writeLock().lock(); //保证线程的完整性
        try {

            System.out.println(Thread.currentThread().getName() + "写入:" + key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "写入完成");
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {

            System.out.println(Thread.currentThread().getName() + "读取：" + key);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取结果：" + result);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}

//读写锁
class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, String value) {
        System.out.println(Thread.currentThread().getName() + "写入:" + key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName() + "写入完成");
    }

    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取：" + key);
        Object result = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取结果：" + result);
    }
}