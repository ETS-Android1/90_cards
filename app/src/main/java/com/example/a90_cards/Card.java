package com.example.a90_cards;

import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Card {

    private String text;
    private String title;
    private CardType cardType = CardType.NormalCard;
    public static int count = 0;

    private Timer timer = null;
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            time--;
            if (time == 0) {
                timer_time_textView.setText("");
                timer_title_textView.setText("");
                timer_time_textView.setBackgroundColor(000000);
                timer.cancel();
                timer.purge();
            } else {
                if (time % 60 < 10) {
                    timer_time_textView.setText(String.valueOf(time / 60 + ":0" + time % 60));
                } else {
                    timer_time_textView.setText(String.valueOf(time / 60 + ":" + time % 60));
                }
            }
        }
    };
    private int time;
    private TextView timer_time_textView;
    private TextView timer_title_textView;

    Card(String title, String text, int time) {
        this.title = title;
        this.text = text;
        this.time = time;

        this.timer = new Timer();
        count++;
    }

    Card(String title, String text) {
        this.title = title;
        this.text = text;
        this.time = 0;
        count++;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public boolean HasTimer() {
        return timer != null;
    }

    public void startTimer() {
        timer_title_textView.setText(title);
        timer_time_textView.setBackgroundColor(0xfff00000);
        timer.schedule(task, 0, 1000);
    }

    public void setTextView(TextView timer_title_textView, TextView timer_time_textView) {
        this.timer_title_textView = timer_title_textView;
        this.timer_time_textView = timer_time_textView;
    }

    public CardType getCardType() {
        return cardType;
    }
}
