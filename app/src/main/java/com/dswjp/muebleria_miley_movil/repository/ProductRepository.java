package com.dswjp.muebleria_miley_movil.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dswjp.muebleria_miley_movil.api.ConfigApi;
import com.dswjp.muebleria_miley_movil.api.ProductApi;
import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.CategoryDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.DetailedProductDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {
    private final ProductApi productApi;
    private static ProductRepository productRepository;

    public ProductRepository() {
        this.productApi = ConfigApi.getProductApi();
    }

    public static ProductRepository getInstance() {
        if (productRepository == null) {
            productRepository = new ProductRepository();
        }
        return productRepository;
    }

    public LiveData<SuccessResponseDTO<List<ProductDTO>>> listProducts() {
        final MutableLiveData<SuccessResponseDTO<List<ProductDTO>>> mld = new MutableLiveData<>();
        this.productApi.getAll().enqueue(new Callback<SuccessResponseDTO<List<ProductDTO>>>() {
            @Override
            public void onResponse(Call<SuccessResponseDTO<List<ProductDTO>>> call, Response<SuccessResponseDTO<List<ProductDTO>>> response) {
                mld.setValue(response.body());
                SuccessResponseDTO<List<ProductDTO>> body = response.body();
                if (body != null && body.getContent() != null) {
                    mld.setValue(body);
                } else {
                    SuccessResponseDTO<List<ProductDTO>> emptyResponse = new SuccessResponseDTO<>();
                    emptyResponse.setContent(new ArrayList<>()); // evita null
                    mld.setValue(emptyResponse);
                }
            }

            @Override
            public void onFailure(Call<SuccessResponseDTO<List<ProductDTO>>> call, Throwable t) {
                SuccessResponseDTO<List<ProductDTO>> errorResponse = new SuccessResponseDTO<>();
                errorResponse.setContent(new ArrayList<>()); // asegura que no sea null
                mld.setValue(errorResponse);
                t.printStackTrace();
            }
        });
        return mld;
    }

    public LiveData<SuccessResponseDTO<List<ProductDTO>>> getByCategoryId(int id){
        final MutableLiveData<SuccessResponseDTO<List<ProductDTO>>> mld = new MutableLiveData<>();
        this.productApi.getByCategoryId(id).enqueue(new Callback<SuccessResponseDTO<List<ProductDTO>>>() {
            @Override
            public void onResponse(Call<SuccessResponseDTO<List<ProductDTO>>> call, Response<SuccessResponseDTO<List<ProductDTO>>> response) {
                mld.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SuccessResponseDTO<List<ProductDTO>>> call, Throwable t) {
                mld.setValue(new SuccessResponseDTO<>());
                t.printStackTrace();
            }
        });
        return mld;
    }
}
