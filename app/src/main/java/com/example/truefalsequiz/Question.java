package com.example.truefalsequiz;

public class Question {
    private String questionText;
    private boolean answer;

    public Question(String question, boolean answer) {
        questionText = question;
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionText='" + questionText + '\'' +
                ", answer=" + answer +
                '}';
    }
}
