package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView test_image = findViewById(R.id.test_image);

        Character character = findViewById(R.id.character);
        character.leftAnimation();
        character.leftAnimation();
        character.leftAnimation();
        character.leftAnimation();
        character.leftAnimation();

//        EnhanceAnimationDrawable enhanceAnimationDrawable = new EnhanceAnimationDrawable();
//        enhanceAnimationDrawable.addFrame(getResources().getDrawable(R.mipmap.male_warrior_run_1), 200);
//        enhanceAnimationDrawable.addFrame(getResources().getDrawable(R.mipmap.male_warrior_run_2), 200);
//        enhanceAnimationDrawable.addFrame(getResources().getDrawable(R.mipmap.male_warrior_run_3), 200);
//        enhanceAnimationDrawable.addFrame(getResources().getDrawable(R.mipmap.male_warrior_run_4), 200);
//        enhanceAnimationDrawable.addFrame(getResources().getDrawable(R.mipmap.male_warrior_run_5), 200);
//        enhanceAnimationDrawable.addFrame(getResources().getDrawable(R.mipmap.male_warrior_run_6), 200);
//        enhanceAnimationDrawable.addFrame(getResources().getDrawable(R.mipmap.male_warrior_run_7), 200);
//        enhanceAnimationDrawable.addFrame(getResources().getDrawable(R.mipmap.male_warrior_run_8), 200);
//        enhanceAnimationDrawable.setOneShot(true);
//        test_image.setBackground(null);
//        test_image.setImageDrawable(enhanceAnimationDrawable);
//        enhanceAnimationDrawable.start(new IAnimationDrawableCallBack() {
//            @Override
//            public void onStart() {
//
//            }
//
//            @Override
//            public void onStop() {
//
//            }
//
//            @Override
//            public void end() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(MainActivity.this, "动画结束", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
    }
}