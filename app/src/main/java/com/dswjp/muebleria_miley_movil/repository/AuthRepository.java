package com.dswjp.muebleria_miley_movil.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dswjp.muebleria_miley_movil.api.AuthApi;
import com.dswjp.muebleria_miley_movil.api.ConfigApi;
import com.dswjp.muebleria_miley_movil.dto.LoginUserDTO;
import com.dswjp.muebleria_miley_movil.dto.NewUserDTO;
import com.dswjp.muebleria_miley_movil.dto.security.JwtTokenDTO;
import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;

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

    public LiveData<SuccessResponseDTO<JwtTokenDTO>> login(LoginUserDTO loginUserDTO) {
        final MutableLiveData<SuccessResponseDTO<JwtTokenDTO>> mld = new MutableLiveData<>();
        this.authApi.login(loginUserDTO).enqueue(new Callback<SuccessResponseDTO<JwtTokenDTO>>() {
            @Override
            public void onResponse(Call<SuccessResponseDTO<JwtTokenDTO>> call, Response<SuccessResponseDTO<JwtTokenDTO>> response) {
                mld.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SuccessResponseDTO<JwtTokenDTO>> call, Throwable t) {
                mld.setValue(new SuccessResponseDTO<>());
                System.out.println(t.getMessage());
                t.printStackTrace();
            }
        });
        return mld;
    }

    public LiveData<SuccessResponseDTO<JwtTokenDTO>> register(NewUserDTO newUserDTO) {
      final MutableLiveData<SuccessResponseDTO<JwtTokenDTO>> mld = new MutableLiveData<>();
      this.authApi.registerUser(newUserDTO).enqueue(new Callback<SuccessResponseDTO<JwtTokenDTO>>() {
          @Override
          public void onResponse(Call<SuccessResponseDTO<JwtTokenDTO>> call, Response<SuccessResponseDTO<JwtTokenDTO>> response) {
              mld.setValue(response.body());
          }

          @Override
          public void onFailure(Call<SuccessResponseDTO<JwtTokenDTO>> call, Throwable t) {
              mld.setValue(new SuccessResponseDTO<>());
              System.out.println(t.getMessage());
              t.printStackTrace();
          }
      });
      return mld;
    };
}
