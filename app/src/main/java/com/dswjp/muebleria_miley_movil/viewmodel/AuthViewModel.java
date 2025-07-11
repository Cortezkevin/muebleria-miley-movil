package com.dswjp.muebleria_miley_movil.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dswjp.muebleria_miley_movil.dto.LoginUserDTO;
import com.dswjp.muebleria_miley_movil.dto.NewUserDTO;
import com.dswjp.muebleria_miley_movil.dto.security.JwtTokenDTO;
import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.repository.AuthRepository;
import com.dswjp.muebleria_miley_movil.security.dto.SessionDTO;

public class AuthViewModel extends AndroidViewModel {

    private final AuthRepository authRepository;
    public AuthViewModel(@NonNull Application application) {
        super(application);
        this.authRepository = AuthRepository.getInstance();
    }

    public LiveData<SuccessResponseDTO<SessionDTO>> login(LoginUserDTO loginUserDTO) {
        return this.authRepository.login(loginUserDTO);
    }

    public LiveData<SuccessResponseDTO<SessionDTO>> register(NewUserDTO newUserDTO) {
        return this.authRepository.register(newUserDTO);
    }
}
