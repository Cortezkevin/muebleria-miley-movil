package com.dswjp.muebleria_miley_movil.api;

import com.dswjp.muebleria_miley_movil.dto.LoginUserDTO;
import com.dswjp.muebleria_miley_movil.dto.NewUserDTO;
import com.dswjp.muebleria_miley_movil.dto.security.JwtTokenDTO;
import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.security.UserDTO;
import com.dswjp.muebleria_miley_movil.security.dto.SessionDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AuthApi {
    String base = "/api/auth";

    @POST(base + "/login")
    Call<SuccessResponseDTO<SessionDTO>> login(@Body LoginUserDTO loginUserDTO);

    @POST(base + "/register")
    Call<SuccessResponseDTO<SessionDTO>> registerUser(@Body NewUserDTO newUserDTO);

    @PUT(base + "/device-token/mobile/{userId}")
    Call<SuccessResponseDTO<String>> saveDeviceToken(
            @Path("userId") String userId,
            @Query("token") String deviceToken
    );

    @GET(base + "/getUserFromToken")
    Call<SuccessResponseDTO<UserDTO>> validateToken();
}
