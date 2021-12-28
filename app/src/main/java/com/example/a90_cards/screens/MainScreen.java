package com.example.a90_cards.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a90_cards.Ninety_cards;
import com.example.a90_cards.R;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_screen);

        Button start_button = (Button) findViewById(R.id.start_button);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, Ninety_cards.class));
            }
        });

        Button language_button = findViewById(R.id.language_button);

        language_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, Language_selector.class));
                overridePendingTransition(R.anim.center_from_right, R.anim.slide_left);
            }
        });
    }
}