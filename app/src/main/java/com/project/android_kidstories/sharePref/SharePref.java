package com.project.android_kidstories.sharePref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class SharePref {

    private static final String LAST_LOGGED_IN ="LAST_LOGGED_IN";
    private static final String ID_KEY="com.project.android_kidstories_ID_KEY";
    private static final String NIGHT_MODE = "NIGHT MODE";

    private static SharePref INSTANCE;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCr(savedInstanceState);
//
//        INSTANCE=SharePref.getINSTANCE(this);
//    }

    private SharePref getSharePref() {
        return INSTANCE;
    }

    private SharePref(SharedPreferences sharedPreferences) {
        this.sharedPreferences=sharedPreferences;

    }
    public static synchronized SharePref getINSTANCE(Context context) {
        if(INSTANCE==null){
            //noinspection deprecation
            INSTANCE = new SharePref(PreferenceManager.getDefaultSharedPreferences(context));
        }
        return INSTANCE;
    }

    private SharedPreferences sharedPreferences;



    public void setLastSunAccess(int hour){
        sharedPreferences.edit().putInt(LAST_LOGGED_IN,hour).apply();
    }

    public void setNightMode(boolean nightMode){
        sharedPreferences.edit().putBoolean(NIGHT_MODE , nightMode).apply();
    }
    public boolean getNightMode(){
        return sharedPreferences.getBoolean(NIGHT_MODE,false);
    }

    public int getLastLoginInHour(){
        return sharedPreferences.getInt(LAST_LOGGED_IN,1);
    }


    public void setLoggedUserId(Long id){
        sharedPreferences.edit().putLong(ID_KEY,id).apply();
    }

    public Long getLoggedUserId(){
        return sharedPreferences.getLong(ID_KEY,-1);
    }


}