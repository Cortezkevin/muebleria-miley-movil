package com.dswjp.muebleria_miley_movil.api;

import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;
import com.dswjp.muebleria_miley_movil.dto.sales.OrderDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SalesApi {

    String base = "/api/order";

    @GET(base)
    Call<SuccessResponseDTO<List<OrderDTO>>> findAll();
}
