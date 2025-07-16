package com.dswjp.muebleria_miley_movil.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dswjp.muebleria_miley_movil.dto.LoginUserDTO;
import com.dswjp.muebleria_miley_movil.dto.NewUserDTO;
import com.dswjp.muebleria_miley_movil.dto.sales.OrderDTO;
import com.dswjp.muebleria_miley_movil.dto.security.JwtTokenDTO;
import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.security.UserDTO;
import com.dswjp.muebleria_miley_movil.repository.AuthRepository;
import com.dswjp.muebleria_miley_movil.repository.OrderRepository;
import com.dswjp.muebleria_miley_movil.repository.ShippingLocationRepository;
import com.dswjp.muebleria_miley_movil.sales.dto.order.DetailedOrderDTO;
import com.dswjp.muebleria_miley_movil.security.dto.SessionDTO;

import java.util.List;

public class ShippingLocationViewModel extends AndroidViewModel {

    private final ShippingLocationRepository shippingLocationRepository;

    public ShippingLocationViewModel(@NonNull Application application) {
        super(application);
        this.shippingLocationRepository = ShippingLocationRepository.getInstance();
    }

    public LiveData<SuccessResponseDTO<List<OrderDTO>>> getAllReadyToSend() {
        return this.shippingLocationRepository.getAllReadyToSend();
    }

}
