package com.example.truefalsequiz;

public class Question {
    private String Question;
    private boolean Answer;

    public Question(String question, boolean answer) {
        Question = question;
        Answer = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public boolean isAnswer() {
        return Answer;
    }

    public void setAnswer(boolean answer) {
        Answer = answer;
    }


}
