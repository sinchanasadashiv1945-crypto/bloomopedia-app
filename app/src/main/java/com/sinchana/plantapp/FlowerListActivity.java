package com.sinchana.plantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class FlowerListActivity extends AppCompatActivity {

    LinearLayout flowerContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_flower_list);

        flowerContainer =
                findViewById(R.id.flowerContainer);

        String category =
                getIntent().getStringExtra("category");

        loadFlowers(category);
    }

    private void loadFlowers(String category) {

        String[] flowers;

        switch (category) {

            // 🌿 MEDICINAL

            case "medicinal":

                flowers = new String[]{
                        "lavender",
                        "hibiscus",
                        "jasmine",
                        "marigold"
                };

                break;

            // 🌸 FRAGRANT

            case "fragrant":

                flowers = new String[]{
                        "rose",
                        "jasmine",
                        "lavender",
                        "lily"
                };

                break;

            // 🌸 SACRED

            case "sacred":

                flowers = new String[]{
                        "lotus",
                        "hibiscus",
                        "marigold",
                        "jasmine"
                };

                break;

            // 🌸 DECORATIVE

            case "decorative":

                flowers = new String[]{
                        "orchid",
                        "tulip",
                        "dahlia",
                        "chrysanthemum",
                        "camellia",
                        "azalea"
                };

                break;

            // 🌸 GARDEN

            default:

                flowers = new String[]{
                        "sunflower",
                        "daisy",
                        "petunia",
                        "zinnia",
                        "pansy",
                        "begonia"
                };
        }

        // 🌸 CREATE BUTTONS

        for (String flower : flowers) {

            Button btn = new Button(this);

            // 🌸 BUTTON TEXT

            btn.setText(capitalize(flower));

            btn.setAllCaps(false);

            btn.setTextSize(20);

            btn.setTextColor(getResources().getColor(android.R.color.white));

            btn.setGravity(Gravity.CENTER);

            // 🌸 BUTTON DESIGN

            btn.setBackgroundColor(
                    0xFFE91E63
            );

            // 🌸 BUTTON SIZE

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            700,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );

            params.gravity = Gravity.CENTER;

            params.setMargins(
                    0,
                    20,
                    0,
                    20
            );

            btn.setLayoutParams(params);

            btn.setPadding(
                    20,
                    30,
                    20,
                    30
            );

            // 🌸 BUTTON CLICK

            btn.setOnClickListener(v -> {

                Intent intent =
                        new Intent(
                                FlowerListActivity.this,
                                FlowerDetailActivity.class
                        );

                intent.putExtra(
                        "flower",
                        flower
                );

                startActivity(intent);
            });

            // 🌸 ADD BUTTON

            flowerContainer.addView(btn);
        }
    }

    // 🌸 CAPITALIZE

    private String capitalize(String s) {

        return s.substring(0, 1).toUpperCase()
                + s.substring(1);
    }
}

