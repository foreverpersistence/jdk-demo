package com.fred.learning.juc.collectionUnsafe;

import java.util.Arrays;
import java.util.List;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-13
 * Desc     :   单线程 安全
 */
public class UnsafeList1 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");

        list.forEach(System.out::println);
    }
}
