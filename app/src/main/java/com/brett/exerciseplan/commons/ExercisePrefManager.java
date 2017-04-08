package com.brett.exerciseplan.commons;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by brett on 2017-04-07.
 */

public class ExercisePrefManager {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private String KEY_LOGIN = "login";

    private String DEFAULT_LOGIN = "NONE";

    private ExercisePrefManager instance;
    private ExercisePrefManager(){
    }

    public ExercisePrefManager getInstance() {
        if(preferences == null)
            instance = new ExercisePrefManager();

        return instance;
    }

    public void init(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
    }

    public void setDefaultValue(){
        setLogin(DEFAULT_LOGIN);
    }

    public void clear() {
        preferences.edit().clear().commit();

        setDefaultValue();
    }

    public void setLogin(String type){
        editor.putString(KEY_LOGIN, type);
        editor.commit();
    }

    public String getLogin(){
        return preferences.getString(KEY_LOGIN, DEFAULT_LOGIN);
    }



}
