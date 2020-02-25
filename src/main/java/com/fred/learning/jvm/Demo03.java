package com.fred.learning.jvm;

import java.util.Random;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-18
 * Desc     :  todo
 */
public class Demo03 {

    public static void main(String[] args) {

        //-Xms:
        //-Xmx：
        //-XX:+PrintGCDetail

        //-Xmn： 新生代

        String s = "hello";

        while (true) {
            s += new Random().toString();
        }

    }
}
