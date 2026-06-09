package com.sinchana.plantapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Locale;

public class FlowerDetailActivity extends AppCompatActivity {

    ImageView flowerImage;

    TextView flowerName;
    TextView flowerInfo;
    TextView flowerExtra;

    Button btnSpeak;
    Button btnMap;

    TextToSpeech tts;

    HashMap<String, Integer> imageMap =
            new HashMap<>();

    HashMap<String, String> infoMap =
            new HashMap<>();

    HashMap<String, String> extraMap =
            new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(
                R.layout.activity_flower_detail);

        flowerImage =
                findViewById(R.id.flowerImage);

        flowerName =
                findViewById(R.id.flowerName);

        flowerInfo =
                findViewById(R.id.flowerInfo);

        flowerExtra =
                findViewById(R.id.flowerExtra);

        btnSpeak =
                findViewById(R.id.btnSpeak);

        btnMap =
                findViewById(R.id.btnMap);

        String flower = getIntent().getStringExtra("flower");

        if (flower == null) {
            flower = "rose";
        }

        flower = flower.toLowerCase().trim();

        initData();

        // 🌸 SET IMAGE

        // 🌸 IMAGE (SAFE)
        Integer img = imageMap.get(flower);
        if (img != null) {
            flowerImage.setImageResource(img);
        } else {
            flowerImage.setImageResource(R.drawable.rose);
        }

// 🌸 NAME
        flowerName.setText(capitalize(flower));

// 🌿 INFO (SAFE)
        String info = infoMap.get(flower);
        if (info != null) {
            flowerInfo.setText(info);
        } else {
            flowerInfo.setText("Information not available.");
        }

// 🌸 EXTRA INFO (SAFE)
        String extra = extraMap.get(flower);
        if (extra != null) {
            flowerExtra.setText(extra);
        } else {
            flowerExtra.setText("Details coming soon.");
        }

        // 🌸 IMAGE ANIMATION

        flowerImage.setAlpha(0f);

        flowerImage.animate()
                .alpha(1f)
                .setDuration(1200)
                .start();

        // 🔊 TEXT TO SPEECH

        tts = new TextToSpeech(this, status -> {

            if (status == TextToSpeech.SUCCESS) {

                tts.setLanguage(Locale.ENGLISH);

                // 🌸 SOFT VOICE

                tts.setPitch(1.1f);

                // 🌸 SLOW CLEAR SPEECH

                tts.setSpeechRate(0.72f);
            }
        });

        // 🔊 AUDIO BUTTON

        btnSpeak.setOnClickListener(v -> {

            String speech =
                    flowerName.getText().toString()
                            + ". "
                            + flowerInfo.getText().toString()
                            + ". "
                            + flowerExtra.getText().toString();

            if (tts != null) {

                tts.speak(
                        speech,
                        TextToSpeech.QUEUE_FLUSH,
                        null,
                        null
                );
            }
        });

        // 📍 MAP BUTTON

        btnMap.setOnClickListener(v -> {

            String location =
                    flowerName.getText().toString()
                            + " flower nursery near me";

            Uri uri =
                    Uri.parse(
                            "https://www.google.com/maps/search/"
                                    + location);

            Intent intent =
                    new Intent(Intent.ACTION_VIEW, uri);

            startActivity(intent);
        });
    }

    // 🌸 CAPITALIZE

    private String capitalize(String s) {

        return s.substring(0, 1).toUpperCase()
                + s.substring(1);
    }

    // 🌿 FLOWER DATA

    private void initData() {

        // 🌸 IMAGES

        imageMap.put("rose", R.drawable.rose);
        imageMap.put("tulip", R.drawable.tulip);
        imageMap.put("sunflower", R.drawable.sunflower);
        imageMap.put("lotus", R.drawable.lotus);
        imageMap.put("jasmine", R.drawable.jasmine);
        imageMap.put("lily", R.drawable.lily);
        imageMap.put("daisy", R.drawable.daisy);
        imageMap.put("marigold", R.drawable.marigold);
        imageMap.put("hibiscus", R.drawable.hibiscus);
        imageMap.put("orchid", R.drawable.orchid);
        imageMap.put("lavender", R.drawable.lavender);
        imageMap.put("dahlia", R.drawable.dahlia);
        imageMap.put("chrysanthemum", R.drawable.chrysanthemum);
        imageMap.put("petunia", R.drawable.petunia);
        imageMap.put("zinnia", R.drawable.zinnia);
        imageMap.put("pansy", R.drawable.pansy);
        imageMap.put("begonia", R.drawable.begonia);
        imageMap.put("camellia", R.drawable.camellia);
        imageMap.put("azalea", R.drawable.azalea);

        // 🌿 BASIC INFO

        infoMap.put("rose",
                "Rose is one of the most beautiful flowers in the world. It has soft petals, sweet fragrance, and many lovely colors.");

        infoMap.put("tulip",
                "Tulip is a colorful flower that blooms during spring season and is famous for its cup-like shape.");

        infoMap.put("sunflower",
                "Sunflower is a tall yellow flower that turns towards the sun and produces healthy seeds.");

        infoMap.put("lotus",
                "Lotus is a sacred flower that grows in water and symbolizes purity and peace.");

        infoMap.put("jasmine",
                "Jasmine is a small white flower with strong fragrance used in perfumes and decoration.");

        infoMap.put("lily",
                "Lily is a graceful flower known for purity and elegance.");

        infoMap.put("daisy",
                "Daisy is a cheerful flower with white petals and yellow center.");

        infoMap.put("marigold",
                "Marigold is a bright flower used in temples, festivals, and decoration.");

        infoMap.put("hibiscus",
                "Hibiscus is a colorful tropical flower commonly used in worship and herbal drinks.");

        infoMap.put("orchid",
                "Orchid is an elegant flower with beautiful patterns and exotic appearance.");

        infoMap.put("lavender",
                "Lavender is a purple flower known for its calming smell and medicinal uses.");

        infoMap.put("dahlia",
                "Dahlia is a flower with many layered petals and bright colors.");

        infoMap.put("chrysanthemum",
                "Chrysanthemum is a decorative flower with soft layered petals.");

        infoMap.put("petunia",
                "Petunia is a colorful garden flower that blooms for a long time.");

        infoMap.put("zinnia",
                "Zinnia is a bright flower loved by butterflies and bees.");

        infoMap.put("pansy",
                "Pansy is a colorful flower with face-like petals.");

        infoMap.put("begonia",
                "Begonia is a beautiful indoor flowering plant with attractive leaves.");



        infoMap.put("camellia",
                "Camellia is a soft elegant flower related to tea plants.");

        infoMap.put("azalea",
                "Azalea is a flowering shrub with beautiful colorful blossoms.");

        // 🌸 EXTRA DETAILS

        extraMap.put("rose",
                "Scientific Name: Rosa\n\n"
                        + "Origin: Asia\n\n"
                        + "Colors: Red, Pink, White, Yellow\n\n"
                        + "Average Size: Medium\n\n"
                        + "Uses: Perfumes, Decoration, Gifts\n\n"
                        + "Flowering Season: Spring\n\n"
                        + "Interesting Fact: Roses are millions of years old.\n\n"
                        + "Why this name: Derived from Latin word Rosa.");

        extraMap.put("sunflower",
                "Scientific Name: Helianthus\n\n"
                        + "Origin: America\n\n"
                        + "Color: Yellow\n\n"
                        + "Average Size: Large\n\n"
                        + "Uses: Oil production and decoration\n\n"
                        + "Flowering Season: Summer\n\n"
                        + "Interesting Fact: Young sunflowers follow the sun.\n\n"
                        + "Why this name: Faces the sun.");

        extraMap.put("lotus",
                "Scientific Name: Nelumbo nucifera\n\n"
                        + "Origin: Asia\n\n"
                        + "Color: Pink and White\n\n"
                        + "Average Size: Large\n\n"
                        + "Uses: Worship and decoration\n\n"
                        + "Flowering Season: Summer\n\n"
                        + "Interesting Fact: Lotus repels water naturally.\n\n"
                        + "Why this name: Sacred aquatic flower.");

        extraMap.put("tulip",
                "Scientific Name: Tulipa\n\n"
                        + "Origin: Turkey\n\n"
                        + "Colors: Mixed\n\n"
                        + "Average Size: Medium\n\n"
                        + "Uses: Garden decoration\n\n"
                        + "Flowering Season: Spring\n\n"
                        + "Interesting Fact: Tulips were once very costly.\n\n"
                        + "Why this name: Looks like a turban.");

        extraMap.put("jasmine",
                "Scientific Name: Jasminum\n\n"
                        + "Origin: Asia\n\n"
                        + "Color: White\n\n"
                        + "Average Size: Small\n\n"
                        + "Uses: Perfumes and hair decoration\n\n"
                        + "Flowering Season: Summer\n\n"
                        + "Interesting Fact: Jasmine flowers bloom at night.\n\n"
                        + "Why this name: Means gift from God.");

        extraMap.put("lily",
                "Scientific Name: Lilium\n\n"
                        + "Origin: Europe\n\n"
                        + "Color: White\n\n"
                        + "Uses: Bouquets and decoration\n\n"
                        + "Why this name: Ancient flower name.");

        extraMap.put("daisy",
                "Scientific Name: Bellis\n\n"
                        + "Origin: Europe\n\n"
                        + "Color: White\n\n"
                        + "Uses: Decoration and gardens\n\n"
                        + "Why this name: Means day's eye.");

        extraMap.put("marigold",
                "Scientific Name: Tagetes\n\n"
                        + "Origin: Mexico\n\n"
                        + "Color: Orange\n\n"
                        + "Uses: Festivals and temples\n\n"
                        + "Why this name: Mary's gold.");

        extraMap.put("hibiscus",
                "Scientific Name: Hibiscus\n\n"
                        + "Origin: Asia\n\n"
                        + "Color: Red\n\n"
                        + "Uses: Herbal drinks and worship\n\n"
                        + "Why this name: Greek origin.");

        extraMap.put("orchid",
                "Scientific Name: Orchidaceae\n\n"
                        + "Origin: Worldwide\n\n"
                        + "Color: Purple\n\n"
                        + "Uses: Indoor decoration\n\n"
                        + "Why this name: Greek word orchis.");

        extraMap.put("lavender",
                "Scientific Name: Lavandula\n\n"
                        + "Origin: Mediterranean\n\n"
                        + "Color: Purple\n\n"
                        + "Uses: Relaxation oils and perfumes\n\n"
                        + "Why this name: Latin word lavare.");

        extraMap.put("dahlia",
                "Scientific Name: Dahlia\n\n"
                        + "Origin: Mexico\n\n"
                        + "Color: Mixed\n\n"
                        + "Uses: Decorative gardens\n\n"
                        + "Why this name: Named after Dahl.");

        extraMap.put("chrysanthemum",
                "Scientific Name: Chrysanthemum\n\n"
                        + "Origin: China\n\n"
                        + "Color: Yellow\n\n"
                        + "Uses: Tea and decoration\n\n"
                        + "Why this name: Golden flower.");

        extraMap.put("petunia",
                "Scientific Name: Petunia\n\n"
                        + "Origin: South America\n\n"
                        + "Color: Mixed\n\n"
                        + "Uses: Gardens\n\n"
                        + "Why this name: Tobacco-like plant.");

        extraMap.put("zinnia",
                "Scientific Name: Zinnia\n\n"
                        + "Origin: Mexico\n\n"
                        + "Color: Mixed\n\n"
                        + "Uses: Butterfly gardens\n\n"
                        + "Why this name: Named after Zinn.");

        extraMap.put("pansy",
                "Scientific Name: Viola\n\n"
                        + "Origin: Europe\n\n"
                        + "Color: Purple\n\n"
                        + "Uses: Cool weather gardens\n\n"
                        + "Why this name: French word pensée.");

        extraMap.put("begonia",
                "Scientific Name: Begonia\n\n"
                        + "Origin: Tropical regions\n\n"
                        + "Color: Pink\n\n"
                        + "Uses: Indoor decoration\n\n"
                        + "Why this name: Named after Begon.");



        extraMap.put("camellia",
                "Scientific Name: Camellia\n\n"
                        + "Origin: Asia\n\n"
                        + "Color: Pink\n\n"
                        + "Uses: Tea and decoration\n\n"
                        + "Why this name: Named after Camellus.");

        extraMap.put("azalea",
                "Scientific Name: Rhododendron\n\n"
                        + "Origin: Asia\n\n"
                        + "Color: Pink\n\n"
                        + "Uses: Gardens\n\n"
                        + "Why this name: Means dry shrub.");
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



