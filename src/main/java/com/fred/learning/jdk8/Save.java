package com.fred.learning.jdk8;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  zzf
 * Time     :  2019-12-22
 * Desc     :  todo
 */
public class Save implements Action {

    private final Editor editor;

    public Save(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.open();
    }
}
