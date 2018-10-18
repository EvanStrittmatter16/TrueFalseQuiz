package com.example.truefalsequiz;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG  = MainActivity.class.getSimpleName();

    private Quiz quiz;
    private TextView textViewQuestion;
    private TextView score;
    private Button ButtonTrue;
    private Button ButtonFalse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WireWidgets();

        // create a gson object
        Gson gson = new Gson();
// read your json file into an array of questions
        Question[] questions =  gson.fromJson(ReadQuestions(), Question[].class);
// convert your array to a list using the Arrays utility class
        List<Question> questionList = Arrays.asList(questions);
// verify that it read everything properly
        Log.d(TAG, "onCreate: " + questionList.toString());

        quiz = new Quiz(questionList);


        Toast.makeText(this, "Are you ready to Start?", Toast.LENGTH_SHORT).show();
        PlayGame();


    }

    private void PlayGame() {
            textViewQuestion.setText(quiz.getNextQuestionText());
            score.setText("Score: " + quiz.getScore());

            ButtonTrue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (quiz.TrueIsCorrect()) {
                        quiz.setScore(quiz.getScore() + 1);
                        Toast.makeText(MainActivity.this, "You're Right!", Toast.LENGTH_SHORT).show();
                    } else {
                        quiz.setScore(quiz.getScore() - 1);

                        Toast.makeText(MainActivity.this, "Wow, you're dumb, How did you get that Wrong?", Toast.LENGTH_SHORT).show();
                    }
                    if (quiz.hasMoreQuestions()) {

                        PlayGame();
                    } else {

                        int s = quiz.getScore();

                        Intent intentScore = new Intent(MainActivity.this, FinishActivity.class);


                            intentScore.putExtra(Intent.EXTRA_TEXT, s);


                        startActivity(intentScore);
                    }
                }
            });
        ButtonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!quiz.TrueIsCorrect()) {
                    quiz.setScore(quiz.getScore() + 1);
                    Toast.makeText(MainActivity.this, "You're Right!", Toast.LENGTH_SHORT).show();
                } else {
                    quiz.setScore(quiz.getScore() - 1);

                    Toast.makeText(MainActivity.this, "Wow, you're dumb, How did you get that Wrong?", Toast.LENGTH_SHORT).show();
                }
                if (quiz.hasMoreQuestions()) {

                    PlayGame();
                } else {
                    //go to new "win" project
                }
            }
        });
    }

    private void WireWidgets() {
        textViewQuestion = findViewById(R.id.textview_quiz_question);
        score = findViewById(R.id.textview_quiz_score);
        ButtonFalse = findViewById(R.id.button_quiz_false);
        ButtonTrue = findViewById(R.id.button_quiz_true);
    }

    private String ReadQuestions() {

        InputStream XmlFileInputStream = getResources().openRawResource(R.raw.questions);
        return readTextFile(XmlFileInputStream);

    }
    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
}
