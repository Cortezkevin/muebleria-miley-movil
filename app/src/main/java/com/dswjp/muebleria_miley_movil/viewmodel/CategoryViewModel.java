package com.dswjp.muebleria_miley_movil.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.CategoryDTO;
import com.dswjp.muebleria_miley_movil.repository.CategoryRepository;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {
    private final CategoryRepository categoryRepository;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        this.categoryRepository = CategoryRepository.getInstance();
    }

    public LiveData<SuccessResponseDTO<List<CategoryDTO>>> listCategories() {
        return this.categoryRepository.listCategories();
    }
}
