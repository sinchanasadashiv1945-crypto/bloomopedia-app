package com.sinchana.plantapp;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class CategoryActivity extends AppCompatActivity {

    TextToSpeech tts;

    ImageView guideFlower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        guideFlower = findViewById(R.id.guideFlower);

        // 🌸 SIMPLE BLINK ANIMATION
        guideFlower.setAlpha(0.4f);

        guideFlower.animate()
                .alpha(1f)
                .setDuration(900)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {

                        guideFlower.animate()
                                .alpha(0.4f)
                                .setDuration(900)
                                .start();
                    }
                })
                .start();

        // 🌸 TEXT TO SPEECH
        tts = new TextToSpeech(this, status -> {

            if (status == TextToSpeech.SUCCESS) {

                tts.setLanguage(Locale.ENGLISH);

                // 🌸 Soft voice
                tts.setPitch(1.1f);

                // 🌸 Slow clear speech
                tts.setSpeechRate(0.72f);

                // 🌸 Category Audio
                tts.speak(
                        "Please choose a flower category.",
                        TextToSpeech.QUEUE_FLUSH,
                        null,
                        null
                );
            }
        });

        // 🌿 CATEGORY BUTTONS
        Button btnMedicinal =
                findViewById(R.id.btnMedicinal);

        Button btnFragrant =
                findViewById(R.id.btnFragrant);

        Button btnSacred =
                findViewById(R.id.btnSacred);

        Button btnDecorative =
                findViewById(R.id.btnDecorative);

        Button btnGarden =
                findViewById(R.id.btnGarden);

        // 🌸 CLICK EVENTS

        btnMedicinal.setOnClickListener(v ->
                openCategory("medicinal"));

        btnFragrant.setOnClickListener(v ->
                openCategory("fragrant"));

        btnSacred.setOnClickListener(v ->
                openCategory("sacred"));

        btnDecorative.setOnClickListener(v ->
                openCategory("decorative"));

        btnGarden.setOnClickListener(v ->
                openCategory("garden"));
    }

    // 🌸 OPEN CATEGORY
    private void openCategory(String category) {

        Intent intent =
                new Intent(
                        CategoryActivity.this,
                        FlowerListActivity.class
                );

        intent.putExtra("category", category);

        startActivity(intent);
    }

    @Override
    protected void onDestroy() {

        if (tts != null) {

            tts.stop();
            tts.shutdown();
        }

        super.onDestroy();
    }
}

