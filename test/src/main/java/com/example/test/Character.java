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
    private final String TAG = "Character";
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
    // 动画结束了的通知
    private int endAnimation = 1;

    private int mDefaultBg;


    private CharacterData mCharacterData;

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
        initCharacterUI(R.mipmap.samurai_model_default);

        initCharacterData();

    }

    private void initCharacterData() {
        mCharacterData = new CharacterData(100, 100, 100, 100, 20, 50, 10, 100, 100, 100);

    }


    public void initCharacterUI(int defaultBg) {
        this.mDefaultBg = defaultBg;
    }


    public void setCharacterBackground(int resId) {
        mCharacter.setBackgroundResource(resId);
    }

    public void upAnimation() {

    }

    public void downAnimation() {

    }


    public void skillAnimation() {
        EnhanceAnimationDrawable skill = getSkillAnimation();
        executeAnimation(skill);
    }


    public void ordinaryAttackAnimation() {
        Log.d(TAG, "执行左的动画");
        EnhanceAnimationDrawable ordinaryAttack = getOrdinaryAttack();
        executeAnimation(ordinaryAttack);
    }

    private EnhanceAnimationDrawable getSkillAnimation() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(R.mipmap.male_skill_1);
        list.add(R.mipmap.male_skill_2);
        list.add(R.mipmap.male_skill_3);
        list.add(R.mipmap.male_skill_4);
        list.add(R.mipmap.male_skill_5);
        list.add(R.mipmap.male_skill_6);
        list.add(R.mipmap.male_skill_7);
        list.add(R.mipmap.male_skill_8);

        Resources resources = mContext.getResources();
        EnhanceAnimationDrawable animation = new EnhanceAnimationDrawable();
        for (int i = 0; i < list.size(); i++) {
            animation.addFrame(resources.getDrawable(list.get(i)), 200);
        }
        return animation;

    }

    private EnhanceAnimationDrawable getOrdinaryAttack() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(R.mipmap.male_warrior_attack_1);
        list.add(R.mipmap.male_warrior_attack_2);
        list.add(R.mipmap.male_warrior_attack_3);
        list.add(R.mipmap.male_warrior_attack_4);
        list.add(R.mipmap.male_warrior_attack_5);

        Resources resources = mContext.getResources();
        EnhanceAnimationDrawable animation = new EnhanceAnimationDrawable();
        for (int i = 0; i < list.size(); i++) {
            animation.addFrame(resources.getDrawable(list.get(i)), 200);
        }
        return animation;

    }


    public void leftAnimation() {
        Log.d(TAG, "执行左的动画");
        EnhanceAnimationDrawable leftAnimation = getLeftAnimation();
        executeAnimation(leftAnimation);
    }


    // 接口
    private EnhanceAnimationDrawable getLeftAnimation() {
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
        return animation;

    }

    // 接口
    private EnhanceAnimationDrawable getRightAnimation() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(R.mipmap.male_warrior_run_10);
        list.add(R.mipmap.male_warrior_run_11);
        list.add(R.mipmap.male_warrior_run_12);
        list.add(R.mipmap.male_warrior_run_13);
        list.add(R.mipmap.male_warrior_run_14);
        list.add(R.mipmap.male_warrior_run_15);
        list.add(R.mipmap.male_warrior_run_16);

        Resources resources = mContext.getResources();
        EnhanceAnimationDrawable animation = new EnhanceAnimationDrawable();
        for (int i = 0; i < list.size(); i++) {
            animation.addFrame(resources.getDrawable(list.get(i)), 200);
        }
        return animation;

    }

    public void rightAnimation() {
        Log.d(TAG, "执行右的动画");
        EnhanceAnimationDrawable rightAnimation = getRightAnimation();
        executeAnimation(rightAnimation);
    }

    private void executeAnimation(EnhanceAnimationDrawable enhanceAnimationDrawable) {
        Log.e(TAG, "executeAnimation: mIsAnimation: " + mIsAnimation);
        // 判断是否在进行动画
        if (mIsAnimation) {
            // 加入队列，等待执行
            Log.e(TAG, "增加等待执行list");
            mWaitAnimationList.add(enhanceAnimationDrawable);
        } else {
            mExecuteAnimation = enhanceAnimationDrawable;
            mIsAnimation = true;
            // 没有动画，直接执行动画
            startAnimation();
        }

    }

    private int test = 0;

    private void startAnimation() {

        mLayout.post(() -> {
            mCharacter.setBackground(null);
            mCharacter.setImageDrawable(mExecuteAnimation);
            // 动画是否执行一次，true 表示仅执行一次，false 表示无限次循环执行动画效果
            mExecuteAnimation.setOneShot(true);
            mExecuteAnimation.start(new IAnimationDrawableCallBack() {
                @Override
                public void onStart() {
                    mIsAnimation = true;
                    Log.e(TAG, "onStart: " + mIsAnimation);
                }

                @Override
                public void onStop() {
                    Log.e(TAG, "onStop: " + mIsAnimation);
                }

                @Override
                public void end() {
                    mIsAnimation = false;
                    test++;
                    Log.e(TAG, "动画结束");
                    Log.e(TAG, "第" + test + "个动画");
                    Log.e(TAG, "mWaitAnimationList" + mWaitAnimationList);
                    Log.e(TAG, "mWaitAnimationList size: " + mWaitAnimationList.size());
//                    debugToast("动画结束");
                    setDefaultBg();
                    // 判断是否还有要执行的动画
                    if (mWaitAnimationList.size() != 0) {
                        Log.e(TAG, "还有没有执行完的动画");
                        executeAnimation(mWaitAnimationList.get(0));
                        mWaitAnimationList.remove(0);
                    }
                }
            });
        });

    }

    public void debugToast(String message) {
        mLayout.post(() -> Toast.makeText(mContext, message, Toast.LENGTH_LONG).show());
    }


    public void setDefaultBg() {
        mCharacter.post(() -> {
            mCharacter.setImageDrawable(null);
            mCharacter.setBackgroundResource(mDefaultBg);
        });

    }

    public void ordinaryAttack(Character enemyCharacter) {
        // 动画效果
        leftAnimation();
        ordinaryAttackAnimation();
        rightAnimation();

        // 获取普通攻击伤害
        long ordinaryAttack = mCharacterData.getOrdinaryAttack();
        Log.e(TAG, "我的普通攻击: " + ordinaryAttack);
        long defense = enemyCharacter.mCharacterData.getDefense();
        Log.e(TAG, "敌人的防御: " + defense);

        // 造成的伤害
        long injuries = ordinaryAttack - defense;
        // 至少造成1点伤害
        if (injuries < 1) {
            injuries = 1;
        }

        // 获取敌人当前血量
        long current_hp = enemyCharacter.mCharacterData.getCurrent_hp();
        // 当前血量减去当前受到的伤害
        long enemyCurrentHp = current_hp - injuries;

        // 防止血量成为负值
        if (enemyCurrentHp < 0) {
            enemyCurrentHp = 0;
        }

        enemyCharacter.mCharacterData.setCurrent_hp(enemyCurrentHp);
        Log.e(TAG,"攻击完，敌人剩余的HP: "+enemyCharacter.mCharacterData.getCurrent_hp());
    }

    private static class CharacterData {
        // 最大血量
        private long hp;
        // 最大魔法值
        private long mp;
        // 当前HP
        private long current_hp;
        // 当前魔法值
        private long current_mp;
        // 普通攻击力
        private long ordinaryAttack;
        // 速度
        private long speed;
        // 防御
        private long defense;
        // 技能伤害
        private long skill_one;
        private long skill_two;
        private long skill_three;

        public CharacterData(long hp, long mp, long current_hp, long current_mp, long ordinaryAttack, long speed, long defense, long skill_one, long skill_two, long skill_three) {
            this.hp = hp;
            this.mp = mp;
            this.current_hp = current_hp;
            this.current_mp = current_mp;
            this.ordinaryAttack = ordinaryAttack;
            this.speed = speed;
            this.defense = defense;
            this.skill_one = skill_one;
            this.skill_two = skill_two;
            this.skill_three = skill_three;
        }

        public long getHp() {
            return hp;
        }

        public void setHp(long hp) {
            this.hp = hp;
        }

        public long getMp() {
            return mp;
        }

        public void setMp(long mp) {
            this.mp = mp;
        }

        public long getCurrent_hp() {
            return current_hp;
        }

        public void setCurrent_hp(long current_hp) {
            this.current_hp = current_hp;
        }

        public long getCurrent_mp() {
            return current_mp;
        }

        public void setCurrent_mp(long current_mp) {
            this.current_mp = current_mp;
        }

        public long getOrdinaryAttack() {
            return ordinaryAttack;
        }

        public void setOrdinaryAttack(long ordinaryAttack) {
            this.ordinaryAttack = ordinaryAttack;
        }

        public long getSpeed() {
            return speed;
        }

        public void setSpeed(long speed) {
            this.speed = speed;
        }

        public long getDefense() {
            return defense;
        }

        public void setDefense(long defense) {
            this.defense = defense;
        }

        public long getSkill_one() {
            return skill_one;
        }

        public void setSkill_one(long skill_one) {
            this.skill_one = skill_one;
        }

        public long getSkill_two() {
            return skill_two;
        }

        public void setSkill_two(long skill_two) {
            this.skill_two = skill_two;
        }

        public long getSkill_three() {
            return skill_three;
        }

        public void setSkill_three(long skill_three) {
            this.skill_three = skill_three;
        }
    }
}
