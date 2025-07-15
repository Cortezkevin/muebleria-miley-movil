package com.dswjp.muebleria_miley_movil.api;

import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;
import com.dswjp.muebleria_miley_movil.dto.profile.information.PersonalDataDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProfileApi {
    String base = "/api/profile";

    @GET(base + "/fromSession")
    Call<SuccessResponseDTO<PersonalDataDTO>> getFromSession();

}
