package com.dswjp.muebleria_miley_movil.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.DetailedProductDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;
import com.dswjp.muebleria_miley_movil.repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    private final ProductRepository productRepository;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        productRepository = ProductRepository.getInstance();
    }

    public LiveData<SuccessResponseDTO<List<ProductDTO>>> listProducts() {
        return this.productRepository.listProducts();
    }

    public LiveData<SuccessResponseDTO<List<ProductDTO>>> getByCategoryId(int id) {
        return this.productRepository.getByCategoryId(id);
    }
}
