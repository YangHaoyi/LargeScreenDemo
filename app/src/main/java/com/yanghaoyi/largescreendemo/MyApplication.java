package com.yanghaoyi.largescreendemo;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @author : YangHaoYi on 2018/11/22.
 *         Email  :  yang.haoyi@qq.com
 *         Description :超长宽高比屏适配Demo
 *         Change : YangHaoYi on 2018/11/22.
 *         Version : V 1.0
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
