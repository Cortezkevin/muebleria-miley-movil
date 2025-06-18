package com.dswjp.muebleria_miley_movil.api;

import com.dswjp.muebleria_miley_movil.dto.LoginUserDTO;
import com.dswjp.muebleria_miley_movil.dto.NewUserDTO;
import com.dswjp.muebleria_miley_movil.dto.security.JwtTokenDTO;
import com.dswjp.muebleria_miley_movil.entity.SuccessResponseDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthApi {
    String base = "/api/auth";

    @POST(base + "/login")
    Call<SuccessResponseDTO<JwtTokenDTO>> login(@Body LoginUserDTO loginUserDTO);

    @POST(base + "/register")
    Call<SuccessResponseDTO<JwtTokenDTO>> registerUser(@Body NewUserDTO newUserDTO);
}
