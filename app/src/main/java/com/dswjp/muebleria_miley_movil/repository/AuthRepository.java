package com.dswjp.muebleria_miley_movil.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dswjp.muebleria_miley_movil.api.AuthApi;
import com.dswjp.muebleria_miley_movil.api.ConfigApi;
import com.dswjp.muebleria_miley_movil.dto.LoginUserDTO;
import com.dswjp.muebleria_miley_movil.dto.NewUserDTO;
import com.dswjp.muebleria_miley_movil.dto.security.JwtTokenDTO;
import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.security.dto.SessionDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {
    private static AuthRepository authRepository;
    private final AuthApi authApi;

    public AuthRepository() {
        this.authApi = ConfigApi.getAuthApi();
    }

    public static AuthRepository getInstance() {
        if (authRepository == null) {
            authRepository = new AuthRepository();
        }
        return authRepository;
    }

    public LiveData<SuccessResponseDTO<SessionDTO>> login(LoginUserDTO loginUserDTO) {
        final MutableLiveData<SuccessResponseDTO<SessionDTO>> mld = new MutableLiveData<>();
        this.authApi.login(loginUserDTO).enqueue(new Callback<SuccessResponseDTO<SessionDTO>>() {
            @Override
            public void onResponse(Call<SuccessResponseDTO<SessionDTO>> call, Response<SuccessResponseDTO<SessionDTO>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mld.setValue(response.body());
                } else {
                    mld.setValue(new SuccessResponseDTO<>());
                }
            }

            @Override
            public void onFailure(Call<SuccessResponseDTO<SessionDTO>> call, Throwable t) {
                mld.setValue(new SuccessResponseDTO<>());
                t.printStackTrace();
            }
        });
        return mld;
    }

    public LiveData<SuccessResponseDTO<SessionDTO>> register(NewUserDTO newUserDTO) {
      final MutableLiveData<SuccessResponseDTO<SessionDTO>> mld = new MutableLiveData<>();
      this.authApi.registerUser(newUserDTO).enqueue(new Callback<SuccessResponseDTO<SessionDTO>>() {
          @Override
          public void onResponse(Call<SuccessResponseDTO<SessionDTO>> call, Response<SuccessResponseDTO<SessionDTO>> response) {
              if (response.isSuccessful() && response.body() != null) {
                  mld.setValue(response.body());
              } else {
                  mld.setValue(new SuccessResponseDTO<>());
              }
          }

          @Override
          public void onFailure(Call<SuccessResponseDTO<SessionDTO>> call, Throwable t) {
              mld.setValue(new SuccessResponseDTO<>());
              System.out.println(t.getMessage());
              t.printStackTrace();
          }
      });
      return mld;
    };

    public LiveData<SuccessResponseDTO<String>> saveDeviceToken(String userId, String token) {
        Log.d("AuthRepository","Calling method saveDeviceToken " + token);
        final MutableLiveData<SuccessResponseDTO<String>> mld = new MutableLiveData<>();
        this.authApi.saveDeviceToken(userId, token).enqueue(new Callback<SuccessResponseDTO<String>>() {
            @Override
            public void onResponse(Call<SuccessResponseDTO<String>> call, Response<SuccessResponseDTO<String>> response) {
                Log.d("AuthRepository", response.toString());
                if (response.isSuccessful() && response.body() != null) {
                    mld.setValue(response.body());
                } else {
                    mld.setValue(new SuccessResponseDTO<>());
                }
            }

            @Override
            public void onFailure(Call<SuccessResponseDTO<String>> call, Throwable t) {
                mld.setValue(new SuccessResponseDTO<>());
                Log.e("AuthRepository", t.getMessage());
                t.printStackTrace();
            }
        });
        return mld;
    };
}
