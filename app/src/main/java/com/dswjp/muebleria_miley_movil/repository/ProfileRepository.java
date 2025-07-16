package com.dswjp.muebleria_miley_movil.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dswjp.muebleria_miley_movil.api.CategoryApi;
import com.dswjp.muebleria_miley_movil.api.ConfigApi;
import com.dswjp.muebleria_miley_movil.api.ProfileApi;
import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.CategoryDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;
import com.dswjp.muebleria_miley_movil.dto.profile.information.PersonalDataDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {
    private final ProfileApi profileApi;
    private static ProfileRepository repository;

    public ProfileRepository() {
        this.profileApi = ConfigApi.getProfileApi();
    }

    public static ProfileRepository getInstance() {
        if (repository == null) {
            repository = new ProfileRepository();
        }
        return repository;
    }

    public LiveData<SuccessResponseDTO<PersonalDataDTO>> getFromSession(){
        Log.d("ProfileRepository","Calling method getFromSession");
        final MutableLiveData<SuccessResponseDTO<PersonalDataDTO>> mld = new MutableLiveData<>();
        this.profileApi.getFromSession().enqueue(new Callback<SuccessResponseDTO<PersonalDataDTO>>() {
            @Override
            public void onResponse(Call<SuccessResponseDTO<PersonalDataDTO>> call, Response<SuccessResponseDTO<PersonalDataDTO>> response) {
                Log.d("ProfileRepository","Response getFromSession " + response.isSuccessful());
                Log.d("ProfileRepository","Data getFromSession " + response.body().toString());
                mld.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SuccessResponseDTO<PersonalDataDTO>> call, Throwable t) {
                mld.setValue(new SuccessResponseDTO<>());
                Log.d("ProfileRepository","Error consumes api " + t.getMessage());
                t.printStackTrace();
            }
        });
        return mld;
    }
}
