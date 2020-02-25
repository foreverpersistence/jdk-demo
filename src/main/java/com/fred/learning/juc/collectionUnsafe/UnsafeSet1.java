package com.fred.learning.juc.collectionUnsafe;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-14
 * Desc     :  todo
 *
 *善于总结：
 *  * 1、 故障现象： ConcurrentModificationException 并发修改异常！
 *  * 2、 导致原因： 并发下 HashSet 存在安全的问题
 *  * 3、 解决方案：
 *  *     Set<String> set = Collections.synchronizedSet(new HashSet<>());  60
 *  *     Set<String> set =new CopyOnWriteArraySet<>();  // 100
 *
 */
public class UnsafeSet1 {

    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();//不安全
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());//安全 60
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,10));
                System.out.println(set);
            }).start();
        }
    }
}
