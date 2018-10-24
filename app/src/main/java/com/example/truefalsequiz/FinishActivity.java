package com.example.truefalsequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {

    private TextView Score;
    private int ScoreValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        WireWidgets();

        ScoreValue = getIntent().getIntExtra(Intent.EXTRA_TEXT, 0);

        Score.setText("Your Final Score is: " + ScoreValue);
    }

    private void WireWidgets() {
        Score = findViewById(R.id.textview_finishactivity_score);
    }
}
