package com.sinchana.plantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    ImageView guideFlower;

    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        guideFlower = findViewById(R.id.guideFlower);

        btnStart = findViewById(R.id.btnStart);

        // 🌸 FLOAT ANIMATION

        Animation animation = AnimationUtils.loadAnimation(
                this,
                R.anim.float_anim
        );

        guideFlower.startAnimation(animation);

        // 🌺 BUTTON

        btnStart.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            WelcomeActivity.this,
                            CategoryActivity.class
                    );

            startActivity(intent);
        });
    }
}