package com.example.tennisscoreboardmobile;

import java.util.Stack;

public class ScoreHistory {
    Stack<ScoreState> previousScoreStates;

    ScoreHistory(){
        previousScoreStates = new Stack<>();
    }
    public void add(ScoreState newScoreState){
        previousScoreStates.push(newScoreState);
    }
    public void removeLastState(){
        previousScoreStates.pop();
    }

    public ScoreState getLastState() {
        return previousScoreStates.peek();
    }

    public boolean isEmpty(){
        return previousScoreStates.isEmpty();
    }
}