package com.dswjp.muebleria_miley_movil.utils.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Optional;

public class SharedPreferencesHelpers {
    private static SharedPreferences getPreferences(Context c){
        return PreferenceManager.getDefaultSharedPreferences(c);
    }

    public static Optional<String> getToken(Context c){
        return Optional.ofNullable(getPreferences(c).getString("token", null));
    }

    public static Optional<String> getUserId(Context c){
        return Optional.ofNullable(getPreferences(c).getString("user-id", null));
    }

    public static void saveToken(Context c, String token){
        getPreferences(c).edit().putString("token", token).apply();
    }

    public static void saveUserId(Context c, String userId){
        getPreferences(c).edit().putString("user-id", userId).apply();
    }
}
