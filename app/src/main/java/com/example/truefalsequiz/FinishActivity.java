package com.example.truefalsequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {

    private TextView Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        WireWidgets();
        Score.setText("Your Final Score is: " + 1);
    }

    private void WireWidgets() {
        Score = findViewById(R.id.textview_quiz_score);
    }
}
