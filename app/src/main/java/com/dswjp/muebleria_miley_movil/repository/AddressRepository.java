package com.dswjp.muebleria_miley_movil.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dswjp.muebleria_miley_movil.api.AddressApi;
import com.dswjp.muebleria_miley_movil.api.CategoryApi;
import com.dswjp.muebleria_miley_movil.api.ConfigApi;
import com.dswjp.muebleria_miley_movil.api.ProfileApi;
import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.CategoryDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;
import com.dswjp.muebleria_miley_movil.dto.profile.address.AddressDTO;
import com.dswjp.muebleria_miley_movil.dto.profile.information.PersonalDataDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddressRepository {
    private final AddressApi addressApi;
    private static AddressRepository repository;

    public AddressRepository() {
        this.addressApi = ConfigApi.getAddressApi();
    }

    public static AddressRepository getInstance() {
        if (repository == null) {
            repository = new AddressRepository();
        }
        return repository;
    }

    public LiveData<SuccessResponseDTO<AddressDTO>> getFromSession(){
        final MutableLiveData<SuccessResponseDTO<AddressDTO>> mld = new MutableLiveData<>();
        this.addressApi.getFromSession().enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<SuccessResponseDTO<AddressDTO>> call, Response<SuccessResponseDTO<AddressDTO>> response) {
                mld.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SuccessResponseDTO<AddressDTO>> call, Throwable t) {
                mld.setValue(new SuccessResponseDTO<>());
                t.printStackTrace();
            }
        });
        return mld;
    }
}
