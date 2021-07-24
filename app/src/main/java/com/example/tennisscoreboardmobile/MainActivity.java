package com.example.tennisscoreboardmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Score score;
    TextView Scoreboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = new Score();
        Scoreboard = findViewById(R.id.textView);
        Scoreboard.setText(score.toString());
    }
    public void incP1(View view) {
        score.incrementPlayer1();
        Scoreboard.setText(score.toString());
    }
    public void incP2(View view) {
        score.incrementPlayer2();
        Scoreboard.setText(score.toString());
    }
    public void undo(View view){
        score.undo();
        Scoreboard.setText(score.toString());
    }
    public void reset(View view){
        ScoreState.Mode mode = score.getMode();
        score.reset();
        score.setMode(mode);
        Scoreboard.setText(score.toString());
    }
    public void changeViewMode(View view){
        if(score.getMode() == ScoreState.Mode.REGULAR) {
            score.setMode(ScoreState.Mode.WIMBLEDON);
        }
        else{
            score.setMode(ScoreState.Mode.REGULAR);
        }
        Scoreboard.setText(score.toString());
    }
}