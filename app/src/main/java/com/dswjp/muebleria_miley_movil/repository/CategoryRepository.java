package com.dswjp.muebleria_miley_movil.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dswjp.muebleria_miley_movil.api.CategoryApi;
import com.dswjp.muebleria_miley_movil.api.ConfigApi;
import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.CategoryDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {
    private final CategoryApi categoryApi;
    private static CategoryRepository repository;

    public CategoryRepository() {
        this.categoryApi = ConfigApi.getCategoryApi();
    }

    public static CategoryRepository getInstance() {
        if (repository == null) {
            repository = new CategoryRepository();
        }
        return repository;
    }

    public LiveData<SuccessResponseDTO<List<CategoryDTO>>> listCategories() {
        final MutableLiveData<SuccessResponseDTO<List<CategoryDTO>>> mld = new MutableLiveData<>();
        this.categoryApi.findAll().enqueue(new Callback<SuccessResponseDTO<List<CategoryDTO>>>() {
            @Override
            public void onResponse(Call<SuccessResponseDTO<List<CategoryDTO>>> call, Response<SuccessResponseDTO<List<CategoryDTO>>> response) {
                mld.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SuccessResponseDTO<List<CategoryDTO>>> call, Throwable t) {
                System.out.println("error al obtener las categorias: " + t.getMessage());
                t.printStackTrace();
            }
        });
        return mld;
    }
}
