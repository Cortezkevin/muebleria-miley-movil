package com.dswjp.muebleria_miley_movil.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dswjp.muebleria_miley_movil.api.ConfigApi;
import com.dswjp.muebleria_miley_movil.api.OrderApi;
import com.dswjp.muebleria_miley_movil.dto.sales.OrderDTO;
import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.sales.dto.order.DetailedOrderDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderRepository {
    private static OrderRepository orderRepository;
    private final OrderApi orderApi;

    public OrderRepository() {
        this.orderApi = ConfigApi.getOrderApi();
    }

    public static OrderRepository getInstance() {
        if (orderRepository == null) {
            orderRepository = new OrderRepository();
        }
        return orderRepository;
    }

    public LiveData<SuccessResponseDTO<List<OrderDTO>>> getAllByUser(String userId) {
        final MutableLiveData<SuccessResponseDTO<List<OrderDTO>>> mld = new MutableLiveData<>();
        this.orderApi.findByUser(userId).enqueue(new Callback<SuccessResponseDTO<List<OrderDTO>>>() {
            @Override
            public void onResponse(Call<SuccessResponseDTO<List<OrderDTO>>> call, Response<SuccessResponseDTO<List<OrderDTO>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mld.setValue(response.body());
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

    public LiveData<SuccessResponseDTO<DetailedOrderDTO>> findById(String orderId) {
        final MutableLiveData<SuccessResponseDTO<DetailedOrderDTO>> mld = new MutableLiveData<>();
        this.orderApi.findById(orderId).enqueue(new Callback<SuccessResponseDTO<DetailedOrderDTO>>() {
            @Override
            public void onResponse(Call<SuccessResponseDTO<DetailedOrderDTO>> call, Response<SuccessResponseDTO<DetailedOrderDTO>> response) {
                Log.d("OrderRepository","Response " + response.isSuccessful() + " " + response.message());
                if (response.isSuccessful() && response.body() != null) {
                    mld.setValue(response.body());
                } else {
                    mld.setValue(new SuccessResponseDTO<>());
                }
            }

            @Override
            public void onFailure(Call<SuccessResponseDTO<DetailedOrderDTO>> call, Throwable t) {
                mld.setValue(new SuccessResponseDTO<>());
                Log.d("OrderRepository","Error findById " + t.getMessage());
                t.printStackTrace();
            }
        });
        return mld;
    }
}
