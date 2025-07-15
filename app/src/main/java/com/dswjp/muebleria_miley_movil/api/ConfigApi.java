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

    public static final String baseUrlE = "http://192.168.1.7:4000";
    private static Retrofit retrofit;
    private static String token = "";
    private static AuthApi authApi;
    private static CategoryApi categoryApi;
    private static ProductApi productApi;
    private static OrderApi orderApi;
    private static ProfileApi profileApi;
    private static AddressApi addressApi;

    private static NotificationApi notificationApi;

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
        Log.d("ConfigApi", "Getting client");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (token != null && !token.isEmpty()) {
            Log.d("ConfigApi", "Adding Authorization header");
            builder.addInterceptor(chain -> {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Authorization", "Bearer " + token)
                        .build();
                return chain.proceed(request);
            });
        } else {
            Log.d("ConfigApi", "No token found");
        }

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logging);

        builder.connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor(new StethoInterceptor());

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

    public static OrderApi getOrderApi() {
        if (orderApi == null) {
            orderApi = retrofit.create(OrderApi.class);
        }
        return orderApi;
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

    public static ProfileApi getProfileApi() {
        if (profileApi == null) {
            profileApi = retrofit.create(ProfileApi.class);
        }
        return profileApi;
    }

    public static AddressApi getAddressApi() {
        if (addressApi == null) {
            addressApi = retrofit.create(AddressApi.class);
        }
        return addressApi;
    }

    public static NotificationApi getNotificationApi() {
        if (notificationApi == null) {
            notificationApi = retrofit.create(NotificationApi.class);
        }
        return notificationApi;
    }
}
