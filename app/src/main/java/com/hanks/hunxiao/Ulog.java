package com.hanks.hunxiao;

import android.util.Log;


/**
 * @author 侯建军
 * @data on 2018/1/4 10:40
 * @org www.hopshine.com
 * @function 请填写
 * @email 474664736@qq.com
 */
public class Ulog {
    private static final String TAG = "hjj-";

    public static void i(Object content) {
        Log.e(TAG, content + "");
    }

    public static void i(Object tag, Object content) {
        Log.e(TAG + tag, content + "");
    }


}
