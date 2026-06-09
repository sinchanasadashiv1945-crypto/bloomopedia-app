package com.sinchana.plantapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView aboutText = findViewById(R.id.aboutText);

        aboutText.setText(
                "🌸 Floweria App 🌸\n\n" +
                        "Floweria is an educational Android application designed to help users learn about different flowers in a simple and interactive way.\n\n" +
                        "✨ Features:\n" +
                        "• Explore flower categories\n" +
                        "• View flower images\n" +
                        "• Read scientific information\n" +
                        "• Listen to audio descriptions\n" +
                        "• Find nearby flower locations using Maps\n\n" +
                        "🌿 Purpose:\n" +
                        "To make learning about flowers easy, visual, and enjoyable for all age groups.\n\n" +
                        "💡 Developed by: Sinchana S"
        );
    }
}