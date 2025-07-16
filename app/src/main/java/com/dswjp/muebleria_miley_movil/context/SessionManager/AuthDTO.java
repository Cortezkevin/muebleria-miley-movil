package com.dswjp.muebleria_miley_movil.context.SessionManager;

import com.dswjp.muebleria_miley_movil.enums.AccessType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class AuthDTO {
    private String userId;
    private String email;
    private boolean isLogged;
    private boolean isAdmin;
    private AccessType accessType;

    public static AuthDTO empty(){
        return new AuthDTO(
                null,
                null,
                false,
                false,
                AccessType.CLIENT
        );
    }
}
