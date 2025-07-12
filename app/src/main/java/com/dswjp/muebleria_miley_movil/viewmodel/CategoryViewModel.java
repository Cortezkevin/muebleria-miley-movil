package com.dswjp.muebleria_miley_movil.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.CategoryDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;
import com.dswjp.muebleria_miley_movil.repository.CategoryRepository;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {
    private final CategoryRepository categoryRepository;
    private MutableLiveData<List<CategoryDTO>> categories;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        this.categoryRepository = CategoryRepository.getInstance();
    }

    public LiveData<List<CategoryDTO>> getCategories(){
        if(categories == null){
            categories = new MutableLiveData<>();
            this.loadCategories();
        }
        return categories;
    }

    public void loadCategories() {
        categoryRepository.listCategories().observeForever(res -> {
            categories.setValue(res.getContent());
        });
    }

    public LiveData<SuccessResponseDTO<List<CategoryDTO>>> listCategories() {
        return this.categoryRepository.listCategories();
    }
}
