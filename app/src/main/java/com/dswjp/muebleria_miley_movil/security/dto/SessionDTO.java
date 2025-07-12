package com.dswjp.muebleria_miley_movil.security.dto;

import com.dswjp.muebleria_miley_movil.security.model.User;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class SessionDTO {
    String token;
    String id;
    String email;
    String photo;
    List<String> roles;

    public SessionDTO(String token, String id, String email, String photo, List<String> roles) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.photo = photo;
        this.roles = roles;
    }

    public static SessionDTO toDTO(User user, String token){
        return new SessionDTO(
                token,
                user.getId(),
                user.getEmail(),
                user.getPersonalInformation().getPhotoUrl(),
                user.getRoles().stream()
                        .map(r -> r.getRolName().name())
                        .collect(Collectors.toList())

        );
    }
    
}
