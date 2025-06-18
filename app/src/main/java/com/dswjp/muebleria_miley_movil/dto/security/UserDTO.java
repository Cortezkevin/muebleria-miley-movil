package com.dswjp.muebleria_miley_movil.dto.security;

import java.util.Set;

public class UserDTO {
    String id;
    String firstName;
    String lastName;
    String email;
    Set<String> roles;
    ProfileDTO profile;
}
