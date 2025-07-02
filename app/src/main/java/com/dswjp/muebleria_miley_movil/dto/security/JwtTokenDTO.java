package com.dswjp.muebleria_miley_movil.dto.security;

public class JwtTokenDTO {
    String token;
    UserDTO user;

    public JwtTokenDTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
