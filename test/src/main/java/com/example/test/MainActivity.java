package com.example.test;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView test_image = findViewById(R.id.test_image);

        Character character = findViewById(R.id.character);

        character.ordinaryAttack(character);

//        character.leftAnimation();
//        character.leftAnimation();
//
//        character.ordinaryAttackAnimation();
//        character.skillAnimation();
//
//        character.rightAnimation();
//        character.rightAnimation();

    }
}