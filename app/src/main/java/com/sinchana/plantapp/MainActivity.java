package com.sinchana.plantapp;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnStart;

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);

        // 🌸 TEXT TO SPEECH
        tts = new TextToSpeech(this, status -> {

            if (status == TextToSpeech.SUCCESS) {

                tts.setLanguage(Locale.ENGLISH);

                // 🌸 Soft child-friendly voice
                tts.setPitch(1.1f);

                // 🌸 Slow understandable speech
                tts.setSpeechRate(0.72f);

                // 🌸 Welcome Audio
                tts.speak(
                        "Welcome to Floweria. Explore the beautiful world of flowers.",
                        TextToSpeech.QUEUE_FLUSH,
                        null,
                        null
                );
            }
        });

        // 🌸 START BUTTON
        btnStart.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            CategoryActivity.class
                    );

            startActivity(intent);
        });
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

