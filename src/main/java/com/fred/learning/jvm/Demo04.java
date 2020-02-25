package com.fred.learning.jvm;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-18
 * Desc     :  -Xms: 初始的内存分配大小，totalMemory  物理内存的 1/64
 *              -Xmx： 最大分配内存    maxMemory   物理内存的 1/4
 *              -XX:PrintGCDetails
 *
 */
public class Demo04 {

    public static void main(String[] args) {

        long max = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();


        System.out.println("maxMemory=" + max/(double)1024/1024 + "MB");
        System.out.println("totalMemory=" + totalMemory/(double)1024/1024 + "MB");
    }
}
