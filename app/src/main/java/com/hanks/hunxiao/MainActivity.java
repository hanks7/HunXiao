package com.hanks.hunxiao;

import android.os.Bundle;

/**
 * 在app下的build.gradle
 * release {
 * minifyEnabled false//是否启动混淆 true:打开   false:关闭
 * proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
 * }
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ulog.i(UDate.getCurrentTime());
    }
}
