package com.abdel.mijnproject.utils;
import android.content.Context;
import android.content.SharedPreferences;

import com.abdel.mijnproject.data.entities.User;
import com.abdel.mijnproject.data.entities.User;


public class Session {
    public static final String LOGIN = "login";

    public static final String name =  "name";
    public static final String emailId =  "passportId";
    public static final String dob =  "dob";
    public static final String USER_SESSION_PREFS = "user_session_prefs";

    public static final String access_key = "6808";



    public static String getUserData(String key, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_SESSION_PREFS, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, null);
    }

    public static String getValue(Context context, String str, String str2) {
        return context.getSharedPreferences(USER_SESSION_PREFS, 0).getString(str, str2);
    }

    public static void setValue(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(USER_SESSION_PREFS, 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static boolean isLogin(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_SESSION_PREFS, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public static void setUserData(String key, String value, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_SESSION_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void saveUserDetail(Context context, User user) {
        SharedPreferences.Editor edit = context.getSharedPreferences(USER_SESSION_PREFS, Context.MODE_PRIVATE).edit();
        edit.putString(name, user.getName());
        edit.putString(emailId, user.getEmailId());
        edit.putString(dob, user.getDob());
        edit.putBoolean(LOGIN, true);
        edit.apply();
    }


    public static void clearUserSession(Context mContext) {
        if (mContext != null) {
            SharedPreferences mSharedPreferences = mContext.getSharedPreferences(USER_SESSION_PREFS, Context.MODE_PRIVATE);
            if (mSharedPreferences != null) {
                mSharedPreferences.edit().remove(name).apply();
                mSharedPreferences.edit().remove(emailId).apply();
                mSharedPreferences.edit().remove(dob).apply();
                mSharedPreferences.edit().remove(LOGIN).apply();
            }
        }
    }
}
