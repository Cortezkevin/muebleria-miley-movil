package com.dswjp.muebleria_miley_movil.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;
import com.dswjp.muebleria_miley_movil.profile.dto.NotificationDTO;
import com.dswjp.muebleria_miley_movil.repository.NotificationRepository;

import java.util.List;

public class NotificationViewModel extends AndroidViewModel {
    private final NotificationRepository notificationRepository;
    private MutableLiveData<List<ProductDTO>> products;
    public NotificationViewModel(@NonNull Application application) {
        super(application);
        notificationRepository = NotificationRepository.getInstance();
    }

    public LiveData<SuccessResponseDTO<List<NotificationDTO>>> getAllFromSession() {
        return this.notificationRepository.getAllFromSession();
    }
}
