package com.dswjp.muebleria_miley_movil.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginUserDTO {
    String email;
    String password;

    public LoginUserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
