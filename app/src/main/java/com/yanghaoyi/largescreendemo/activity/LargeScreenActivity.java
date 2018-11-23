package com.yanghaoyi.largescreendemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.orhanobut.logger.Logger;
import com.yanghaoyi.largescreendemo.R;



/**
 * @author : YangHaoYi on 2018/11/22.
 *         Email  :  yang.haoyi@qq.com
 *         Description :超长宽高比屏适配Demo
 *         Change : YangHaoYi on 2018/11/22.
 *         Version : V 1.0
 */
public class LargeScreenActivity extends FragmentActivity{

    private static final String TAG = "LargeScreenDemo:";
    private FrameLayout fmParent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_screen);
        init();
        printRootViewWidthAndHeight();
        printScreenWidthAndHeightByDisplayMetrics();
        printScreenWidthAndHeightByWindowManager();
    }

    private void init(){
        fmParent = (FrameLayout) findViewById(R.id.fmParent);
    }

    private void printRootViewWidthAndHeight(){
        fmParent.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                fmParent.getViewTreeObserver().removeOnPreDrawListener(this);
                int width = fmParent.getWidth();
                int height = fmParent.getHeight();
                Logger.t(TAG).d("ParentView_width_is:  "+width+"  height_is:  "+height);
                return true;
            }
        });
    }

    private void printScreenWidthAndHeightByDisplayMetrics(){
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        Logger.t(TAG).d("Screen_width_is:  "+width+"  height_is:  "+height);
    }

    private void printScreenWidthAndHeightByWindowManager(){
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        Logger.t(TAG).d("Screen_width_is:  "+width+"  height_is:  "+height);
    }




}
