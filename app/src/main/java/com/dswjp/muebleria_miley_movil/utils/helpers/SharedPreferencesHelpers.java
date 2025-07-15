package com.dswjp.muebleria_miley_movil.utils.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.dswjp.muebleria_miley_movil.activity.LoginActivity;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public static Optional<String> getEmail(Context c){
        return Optional.ofNullable(getPreferences(c).getString("email", null));
    }

    public static Optional<Set<String>> getRoles(Context c){
        return Optional.ofNullable(getPreferences(c).getStringSet("roles", null));
    }


    public static void saveToken(Context c, String token){
        getPreferences(c).edit().putString("token", token).apply();
    }

    public static void saveUserId(Context c, String userId){
        getPreferences(c).edit().putString("user-id", userId).apply();
    }

    public static void saveEmail(Context c, String email) {
        getPreferences(c).edit().putString("email", email).apply();
    }

    public static void saveRoles(Context c, List<String> roles) {
        getPreferences(c).edit().putStringSet("roles", new HashSet<>(roles)).apply();
    }

    public static void removeToken(Context c){
        getPreferences(c).edit().remove("token").apply();
    }

    public static void removeUserId(Context c){
        getPreferences(c).edit().remove("user-id").apply();
    }

    public static void removeEmail(Context c) {
        getPreferences(c).edit().remove("email").apply();
    }

    public static void removeRoles(Context c) {
        getPreferences(c).edit().remove("roles").apply();
    }
}
