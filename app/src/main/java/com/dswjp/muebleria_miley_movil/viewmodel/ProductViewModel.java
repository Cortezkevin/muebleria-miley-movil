package com.dswjp.muebleria_miley_movil.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.DetailedProductDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;
import com.dswjp.muebleria_miley_movil.repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    private final ProductRepository productRepository;
    private MutableLiveData<List<ProductDTO>> products;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        productRepository = ProductRepository.getInstance();
    }

    public LiveData<List<ProductDTO>> getProducts(){
        if(products == null){
            products = new MutableLiveData<>();
            this.loadProducts();
        }
        return products;
    }

    public LiveData<SuccessResponseDTO<List<ProductDTO>>> listProducts() {
        return this.productRepository.listProducts();
    }

    public void loadProducts() {
        productRepository.listProducts().observeForever(res -> {
            products.setValue(res.getContent());
        });
    }

    public LiveData<SuccessResponseDTO<List<ProductDTO>>> getByCategoryId(int id) {
        return this.productRepository.getByCategoryId(id);
    }
}
