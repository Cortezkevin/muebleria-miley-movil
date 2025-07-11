package com.dswjp.muebleria_miley_movil.api;

import android.content.SharedPreferences;
import android.util.Log;

import com.dswjp.muebleria_miley_movil.utils.DateSerializer;
import com.dswjp.muebleria_miley_movil.utils.TimeSerializer;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Date;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigApi {

    /*
    ip en universidad
    public static final String baseUrlE =
    "http://10.250.240.11:4000" */

    public static final String baseUrlE = "http://10.250.240.11:4000";
    private static Retrofit retrofit;
    private static String token = "";
    private static AuthApi authApi;
    private static CategoryApi categoryApi;
    private static ProductApi productApi;

    static {
        initClient();
    }

    private static void initClient() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateSerializer())
                .registerTypeAdapter(Time.class, new TimeSerializer())
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrlE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getClient())
                .build();
    }

    public static OkHttpClient getClient() {
        Log.d("ConfigApi","Getting client");
        HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();
        loggin.level(HttpLoggingInterceptor.Level.BODY);

        StethoInterceptor stetho = new StethoInterceptor();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(loggin)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor(stetho);
        if ( token != null && !token.isEmpty() ) {
            Log.d("ConfigApi","Adding Interceptor Token: " + token);
            builder.addInterceptor( chain -> {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Authorization", "Bearer " + token)
                        .build();
                return chain.proceed(request);
            });
        }else {
            Log.d("ConfigApi","Not Token");
        }

        return builder.build();
    }

    public static void setToken(String value) {
        token = value;
        initClient();
    }

    public static AuthApi getAuthApi() {
        if (authApi == null) {
            authApi = retrofit.create(AuthApi.class);
        }
        return authApi;
    }

    public static CategoryApi getCategoryApi() {
        if (categoryApi == null) {
            categoryApi = retrofit.create(CategoryApi.class);
        }
        return categoryApi;
    }

    public static ProductApi getProductApi() {
        if (productApi == null) {
            productApi = retrofit.create(ProductApi.class);
        }
        return productApi;
    }

}
