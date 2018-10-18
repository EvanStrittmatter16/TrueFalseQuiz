package com.example.truefalsequiz;

import java.util.List;

public class Quiz {

    private int questionNumber; //Question number
    private int score;
    private List<Question> questionList;
    private int TotalQuestions = 10;

    public Quiz(List<com.example.truefalsequiz.Question> questionList) {
        this.questionList = questionList;
        score = 0;
        questionNumber = 1;
    }


    public Boolean TrueIsCorrect() {
        boolean correct = true;
        boolean answer = getQuestion().getAnswer();

        return correct==answer;

    }

    public Boolean hasMoreQuestions() {
        boolean Yes = true;
        if(questionNumber + 1 > TotalQuestions){
            Yes = false;

        }

        return Yes;

    }


    public Question getQuestion(){

        Question q;

            q = questionList.get(questionNumber);
            return q;

    }

    public Question getNextQuestion(){

        Question q= null;
        if(hasMoreQuestions()) {
            q = questionList.get(questionNumber + 1);

            questionNumber++;
            return q;
        }
        return q;
    }

    public String getNextQuestionText() {
        String q = null;
        if(hasMoreQuestions()){
         q = questionList.get(questionNumber + 1).getQuestionText();

         questionNumber++;
          return q;

        }


        return q;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestion(int question) {
        questionNumber = question;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<com.example.truefalsequiz.Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<com.example.truefalsequiz.Question> questionList) {
        this.questionList = questionList;
    }
}
