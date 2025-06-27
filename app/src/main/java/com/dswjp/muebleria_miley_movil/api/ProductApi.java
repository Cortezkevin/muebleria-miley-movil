package com.dswjp.muebleria_miley_movil.api;

import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.DetailedProductDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;
import com.dswjp.muebleria_miley_movil.entity.service.catalog.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductApi {
    String base = "/api/product";

    @GET(base + "/public")
    Call<SuccessResponseDTO<List<ProductDTO>>> getAll();

    /*@GET(base + "/public/{id}")
    Call<SuccessResponseDTO<DetailedProductDTO>> getDetailsById(@Path("id") int id);*/
}
