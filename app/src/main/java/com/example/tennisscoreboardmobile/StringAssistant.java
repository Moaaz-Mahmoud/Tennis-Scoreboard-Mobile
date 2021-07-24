package com.example.tennisscoreboardmobile;

public class StringAssistant{
    public static String placeNameInField(String name){
        StringBuilder nameInFieldBuilder = new StringBuilder();
        nameInFieldBuilder.append(name.substring(0, Math.min(ScoreState.NAME_MAX_LENGTH, name.length())));
        for(int i = 0; i < ScoreState.NAME_FIELD - name.length(); i++)
            nameInFieldBuilder.append(" ");
        return nameInFieldBuilder.toString();
    }
}