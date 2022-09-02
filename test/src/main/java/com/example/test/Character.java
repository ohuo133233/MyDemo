package com.example.test;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class Character extends ConstraintLayout {
    private String TAG = "Character";
    private Context mContext;
    // 整个布局
    private View mLayout;
    // 角色
    private ImageView mCharacter;
    // 是否在执行动画
    private boolean mIsAnimation;
    // 正在执行的动画
    private EnhanceAnimationDrawable mExecuteAnimation;
    // 等待执行的动画
    private ArrayList<EnhanceAnimationDrawable> mWaitAnimationList = new ArrayList();

    public Character(@NonNull Context context) {
        super(context);
        init(context);
    }

    public Character(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Character(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mLayout = LayoutInflater.from(context).inflate(R.layout.character, this, true);
        mCharacter = mLayout.findViewById(R.id.character_image);

        new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    // 循环检测动画是否已经结束
                    if (!mIsAnimation) {
                        // 已经没有动画需要执行了
                        Log.d(TAG, "mWaitAnimationList size:" + mWaitAnimationList.size());
                        if (mWaitAnimationList.size() != 0) {
                            mIsAnimation = true;
                            Log.d(TAG, "0:" + mWaitAnimationList.toString());
                            // 动画结束,从等待的动画list取出第一个放到执行动画的list
                            mExecuteAnimation = mWaitAnimationList.get(0);
                            Log.d(TAG, "1:" + mWaitAnimationList.toString());
                            mWaitAnimationList.remove(0);
                            startAnimation();
                        }
                    }
                }
            }
        }.start();
    }


    public void setCharacterBackground(int resId) {
        mCharacter.setBackgroundResource(resId);
    }

    public void upAnimation() {

    }

    public void downAnimation() {

    }


    public void leftAnimation() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(R.mipmap.male_warrior_run_1);
        list.add(R.mipmap.male_warrior_run_2);
        list.add(R.mipmap.male_warrior_run_3);
        list.add(R.mipmap.male_warrior_run_4);
        list.add(R.mipmap.male_warrior_run_5);
        list.add(R.mipmap.male_warrior_run_6);
        list.add(R.mipmap.male_warrior_run_7);
        list.add(R.mipmap.male_warrior_run_8);

        Resources resources = mContext.getResources();
        EnhanceAnimationDrawable animation = new EnhanceAnimationDrawable();
        for (int i = 0; i < list.size(); i++) {
            animation.addFrame(resources.getDrawable(list.get(i)), 200);
        }

        executeAnimation(animation);
    }

    public void rightAnimation() {

    }

    private void executeAnimation(EnhanceAnimationDrawable enhanceAnimationDrawable) {
        // 判断是否在进行动画
        if (mIsAnimation) {
            // 加入队列，等待执行
            Log.d(TAG, "增加等待执行list");
            mWaitAnimationList.add(enhanceAnimationDrawable);
        } else {

            mExecuteAnimation = enhanceAnimationDrawable;
            // 没有动画，直接执行动画
            startAnimation();
        }

    }

    private void startAnimation() {
        mIsAnimation = true;

        mCharacter.setBackground(null);
        mCharacter.setImageDrawable(mExecuteAnimation);
        mExecuteAnimation.setOneShot(true);
        mExecuteAnimation.start(new IAnimationDrawableCallBack() {
            @Override
            public void onStart() {

            }

            @Override
            public void onStop() {

            }

            @Override
            public void end() {
                mIsAnimation = false;
                debugToast("动画结束");
            }
        });
    }

    public void debugToast(String message) {
        mLayout.post(() -> Toast.makeText(mContext, message, Toast.LENGTH_LONG).show());

    }

}
