package com.fred.learning.juc.collectionUnsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-13
 * Desc     :  多线程 不安全
 *      1. Vector
 *      2. Collections.synchronizedList
 *      3. CopyOnWriteArrayList
 *
 */
public class UnsafeList2 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        List<Object> objects = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            }).start();
        }
    }
}
