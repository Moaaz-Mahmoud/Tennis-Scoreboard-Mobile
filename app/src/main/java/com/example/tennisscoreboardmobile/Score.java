package com.example.tennisscoreboardmobile;

import androidx.annotation.NonNull;

import java.util.EmptyStackException;

public class Score {
    ScoreState state;
    ScoreHistory history;
    Score(){
        state = new ScoreState();
        history = new ScoreHistory();
    }
    Score(Score other){
        state = other.state;
        history = other.history;
    }
    ScoreState.Mode getMode(){
        return state.getMode();
    }
    void setMode(ScoreState.Mode newMode){
        state.setMode(newMode);
    }
    void incrementPlayer1(){
        history.add(new ScoreState(state));
        state.incrementPlayer1();
    }
    void incrementPlayer2(){
        history.add(new ScoreState(state));
        state.incrementPlayer2();
    }
    void undo() throws EmptyStackException{
        ScoreState.Mode mode = state.getMode();
        try{
            state = history.getLastState();
            history.removeLastState();
        }
        catch (EmptyStackException error){
            //Do nothing.
        }
        setMode(mode);
    }
    public void reset(){
        ScoreState.Mode mode = state.getMode();
        history.add(new ScoreState(state));
        state.reset();
        setMode(mode);
    }
    @NonNull
    @Override
    public String toString() {
        return state.toString();
    }
}
