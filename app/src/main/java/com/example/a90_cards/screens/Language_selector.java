package com.example.a90_cards.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a90_cards.Ninety_cards;
import com.example.a90_cards.R;

public class Language_selector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        ImageButton italian_button = findViewById(R.id.italian_button);

        italian_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ninety_cards.setLanguage(Ninety_cards.Language.ITALIAN);
                finish();
                overridePendingTransition(R.anim.center_from_left, R.anim.slide_right);
            }
        });

        ImageButton english_button = findViewById(R.id.english_button);

        english_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ninety_cards.setLanguage(Ninety_cards.Language.ENGLISH);
                finish();
                overridePendingTransition(R.anim.center_from_left, R.anim.slide_right);
            }
        });

        Button back_button = findViewById(R.id.back_button);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.center_from_left, R.anim.slide_right);
            }
        });
    }
}
