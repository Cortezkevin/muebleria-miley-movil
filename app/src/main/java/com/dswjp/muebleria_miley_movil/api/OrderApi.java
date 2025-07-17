package com.dswjp.muebleria_miley_movil.api;

import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.sales.OrderDTO;
import com.dswjp.muebleria_miley_movil.sales.dto.order.DetailedOrderDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OrderApi {
    String base = "/api/order";

    @GET(base + "/findBy/{userId}")
    Call<SuccessResponseDTO<List<OrderDTO>>> findByUser(@Path("userId") String userId);

    @GET(base + "/{orderId}")
    Call<SuccessResponseDTO<DetailedOrderDTO>> findById(@Path("orderId") String orderId);

    @GET(base)
    Call<SuccessResponseDTO<List<OrderDTO>>> getAllReadyToSend();
}
