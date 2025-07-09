package com.dswjp.muebleria_miley_movil.api;

import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.CategoryDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.DetailedProductDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryApi {
    String base = "api/category";

    @GET(base + "/public")
    Call<SuccessResponseDTO<List<CategoryDTO>>> findAll();
}
