package com.fred.learning.design.singleton;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2020-02-19
 * Desc     :  todo
 */
public class Holder {

    private Holder() {}


    public static Holder getInstance() {

        return InnerClass.HOLDER;
    }

    private static class InnerClass {
        private static final Holder HOLDER= new Holder();

    }
}



