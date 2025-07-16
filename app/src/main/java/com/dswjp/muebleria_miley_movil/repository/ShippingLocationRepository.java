package com.dswjp.muebleria_miley_movil.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dswjp.muebleria_miley_movil.api.ConfigApi;
import com.dswjp.muebleria_miley_movil.api.OrderApi;
import com.dswjp.muebleria_miley_movil.api.ShippingLocationApi;
import com.dswjp.muebleria_miley_movil.dto.sales.OrderDTO;
import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.sales.dto.order.DetailedOrderDTO;
import com.facebook.stetho.server.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShippingLocationRepository {
    private static ShippingLocationRepository shippingLocationRepository;
    private final ShippingLocationApi shippingLocationApi;

    public ShippingLocationRepository() {
        this.shippingLocationApi = ConfigApi.getShippingLocationApi();
    }

    public static ShippingLocationRepository getInstance() {
        if (shippingLocationRepository == null) {
            shippingLocationRepository = new ShippingLocationRepository();
        }
        return shippingLocationRepository;
    }

    public LiveData<SuccessResponseDTO<List<OrderDTO>>> getAllReadyToSend() {
        final MutableLiveData<SuccessResponseDTO<List<OrderDTO>>> mld = new MutableLiveData<>();
        this.shippingLocationApi.getAllReadyToSend().enqueue(new Callback<SuccessResponseDTO<List<OrderDTO>>>() {
            @Override
            public void onResponse(Call<SuccessResponseDTO<List<OrderDTO>>> call, Response<SuccessResponseDTO<List<OrderDTO>>> response) {
                Log.d("ShippingLocation","Response " + response.toString());
                if (response.isSuccessful() ) {
                    if(response.code() == 204){
                        mld.setValue(new SuccessResponseDTO<>("Solicitud Satisfactoria", true, "No Content", new ArrayList<>()));
                    }else {
                        mld.setValue(response.body());
                    }
                } else {
                    mld.setValue(new SuccessResponseDTO<>());
                }
            }

            @Override
            public void onFailure(Call<SuccessResponseDTO<List<OrderDTO>>> call, Throwable t) {
                mld.setValue(new SuccessResponseDTO<>());
                t.printStackTrace();
            }
        });
        return mld;
    }
}
