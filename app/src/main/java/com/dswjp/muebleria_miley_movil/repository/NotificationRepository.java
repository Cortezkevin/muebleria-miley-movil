package com.dswjp.muebleria_miley_movil.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dswjp.muebleria_miley_movil.api.ConfigApi;
import com.dswjp.muebleria_miley_movil.api.NotificationApi;
import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.profile.dto.NotificationDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationRepository {
    private static NotificationRepository notificationRepository;
    private final NotificationApi notificationApi;

    public NotificationRepository() {
        this.notificationApi = ConfigApi.getNotificationApi();
    }

    public static NotificationRepository getInstance() {
        if (notificationRepository == null) {
            notificationRepository = new NotificationRepository();
        }
        return notificationRepository;
    }

    public LiveData<SuccessResponseDTO<List<NotificationDTO>>> getAllFromSession() {
        final MutableLiveData<SuccessResponseDTO<List<NotificationDTO>>> mld = new MutableLiveData<>();
        this.notificationApi.getAllFromSession().enqueue(new Callback<SuccessResponseDTO<List<NotificationDTO>>>() {
            @Override
            public void onResponse(Call<SuccessResponseDTO<List<NotificationDTO>>> call, Response<SuccessResponseDTO<List<NotificationDTO>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mld.setValue(response.body());
                } else {
                    mld.setValue(new SuccessResponseDTO<>());
                }
            }

            @Override
            public void onFailure(Call<SuccessResponseDTO<List<NotificationDTO>>> call, Throwable t) {
                mld.setValue(new SuccessResponseDTO<>());
                t.printStackTrace();
            }
        });
        return mld;
    }
}
