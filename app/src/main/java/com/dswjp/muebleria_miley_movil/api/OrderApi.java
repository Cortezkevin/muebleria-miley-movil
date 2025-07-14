package com.dswjp.muebleria_miley_movil.api;

import com.dswjp.muebleria_miley_movil.dto.LoginUserDTO;
import com.dswjp.muebleria_miley_movil.dto.NewUserDTO;
import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.sales.OrderDTO;
import com.dswjp.muebleria_miley_movil.dto.security.UserDTO;
import com.dswjp.muebleria_miley_movil.security.dto.SessionDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OrderApi {
    String base = "/api/order";

    @GET(base + "/findBy/{userId}")
    Call<SuccessResponseDTO<List<OrderDTO>>> getAll(@Path("userId") String userId);
}
