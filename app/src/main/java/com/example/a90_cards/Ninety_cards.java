package com.example.a90_cards;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a90_cards.screens.FinalScreen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ninety_cards extends AppCompatActivity {

    public enum Language {ITALIAN, ENGLISH}

    private static Language chosen_language = Language.ENGLISH;

    private Deck card_deck = new Deck();
    private List<Card> card_list = new ArrayList();

    private TextView card_text;
    private TextView message_number;
    private TextView card_title;
    private TextView small_title;
    private TextView timer_time_left;
    private TextView timer_title_left;
    private TextView timer_time_right;
    private TextView timer_title_right;

    private ImageView card_icon;
    private Card playing_card;

    List<TextView> timers = new ArrayList<>();

    private int time = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Card.count = 0;

        card_text = findViewById(R.id.card_question);
        message_number = findViewById(R.id.card_number);
        card_title = findViewById(R.id.title_text);
        card_icon = findViewById(R.id.card_icon_Image);
        small_title = findViewById(R.id.small_title);
        timer_time_left = findViewById(R.id.timer_time_left);
        timer_title_left = findViewById(R.id.timer_title_left);
        timer_time_right = findViewById(R.id.timer_time_right);
        timer_title_right = findViewById(R.id.timer_title_right);

        timers.add(timer_title_left);
        timers.add(timer_title_right);

        card_text.setMovementMethod(new ScrollingMovementMethod());


        card_icon.setVisibility(View.GONE);

        JSONObject obj = new JSONObject();

        switch (chosen_language) {
            case ITALIAN:
                try {
                    obj = new JSONObject(loadJSONFromAsset("ITA"));
                } catch (org.json.JSONException ex) {
                    System.out.println(ex.fillInStackTrace());
                }
                break;

            case ENGLISH:
                try {
                    obj = new JSONObject(loadJSONFromAsset("ENG"));
                } catch (org.json.JSONException ex) {
                    System.out.println(ex.fillInStackTrace());
                }
                break;
        }

        JSONArray cards;
        try {
            cards = obj.getJSONArray("cards");

            for (int i = 0; i < cards.length(); i++) {
                JSONObject json = cards.getJSONObject(i);
                String title = json.getString("title");
                String text = json.getString("text");
                Integer time = json.getInt("time");

                Card card = (time == 0) ? new Card(title, text) : new Card(title, text, time);

                card_list.add(card);
            }

            Collections.shuffle(card_list);

            for (Card card : card_list) {
                card_deck.push(card);
            }

            timer_title_left.setVisibility(View.GONE);
            timer_title_right.setVisibility(View.GONE);

            showTitle();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset(String file) {
        String json = null;
        try {
            InputStream is = getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            System.out.println("File not found! Try changing the name or to locate the file.");
        }
        return json;
    }



    private void get_card() {
        card_text.setVisibility(View.VISIBLE);
        card_icon.setVisibility(View.VISIBLE);
        small_title.setVisibility(View.VISIBLE);
        card_title.setVisibility(View.GONE);
        small_title.setText(playing_card.getTitle());
        card_text.setText(playing_card.getText());

        card_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playing_card.HasTimer()) {
                    if (timer_title_left.getText().equals("")) {
                        timer_title_left.setVisibility(View.VISIBLE);
                        playing_card.setTextView(timer_title_left, timer_time_left);
                        playing_card.startTimer();
                    } else if (timer_title_right.getText().equals("")) {
                        timer_title_right.setVisibility(View.VISIBLE);
                        playing_card.setTextView(timer_title_right, timer_time_right);
                        playing_card.startTimer();
                    }
                }
                showTitle();
            }
        });
    }


    public static void setLanguage(Language language) {
        chosen_language = language;
    }


    private int count = 0;

    private void showTitle() {
        if (card_deck.isEmpty()) {
            card_list.clear();
            super.startActivity(new Intent(Ninety_cards.this, FinalScreen.class));
        } else {
            playing_card = card_deck.pop();
            count++;
            card_text.setVisibility(View.GONE);
            card_icon.setVisibility(View.GONE);
            small_title.setVisibility(View.GONE);
            card_title.setVisibility(View.VISIBLE);

            card_title.setText(playing_card.getTitle());
            message_number.setText(count + "/" + Card.count);
        }
    }

    public void screenTapped(View view) {
        get_card();
        card_text.scrollTo(0, 0);
    }

    @Override
    public void onBackPressed() {
        card_text.setVisibility(View.GONE);
        card_icon.setVisibility(View.GONE);
        small_title.setVisibility(View.GONE);
        card_title.setVisibility(View.VISIBLE);

        card_title.setText(playing_card.getTitle());
    }
}