package com.dswjp.muebleria_miley_movil.dto.security;

import java.util.Set;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<String> roles;
    private String photoUrl;
    private ProfileDTO profile;
}
