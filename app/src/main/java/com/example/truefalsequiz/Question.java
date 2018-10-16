package com.example.truefalsequiz;

public class Question {
    private String questionText;
    private boolean Answer;

    public Question(String question, boolean answer) {
        questionText = question;
        Answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean getAnswer() {
        return Answer;
    }

    public void setAnswer(boolean answer) {
        Answer = answer;
    }


}
