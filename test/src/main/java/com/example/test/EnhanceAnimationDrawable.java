package com.example.test;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;


public class EnhanceAnimationDrawable extends AnimationDrawable {
    private IAnimationDrawableCallBack mIAnimationDrawableCallBack;
    private Drawable mLastDrawable;


    @Override
    public void addFrame(@NonNull Drawable frame, int duration) {
        super.addFrame(frame, duration);
        mLastDrawable = frame;
    }


    public void start(IAnimationDrawableCallBack iAnimationDrawableCallBack) {
        mIAnimationDrawableCallBack = iAnimationDrawableCallBack;
        super.start();
        mIAnimationDrawableCallBack.onStart();
        isEnd();

    }

    @Override
    public void stop() {
        if (mIAnimationDrawableCallBack != null) {
            mIAnimationDrawableCallBack.onStop();
        }
        super.stop();
    }

    // 检测动画是否停止
    private void isEnd() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    Drawable current = getCurrent();
                    if (current == mLastDrawable) {
                        if (mIAnimationDrawableCallBack != null) {
                            mIAnimationDrawableCallBack.end();
                        }
                        return;
                    }
                }
            }
        }.start();
    }


}
