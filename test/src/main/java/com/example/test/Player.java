package com.example.test;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class Player extends Character {

    public Player(@NonNull Context context) {
        super(context);
    }

    public Player(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Player(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
