package com.dswjp.muebleria_miley_movil.entity.security;

import com.dswjp.muebleria_miley_movil.entity.Cart;
import com.dswjp.muebleria_miley_movil.entity.PersonalInformation;
import com.dswjp.muebleria_miley_movil.enums.Status;

import java.util.HashSet;
import java.util.Set;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;
    private String email;
    private String password;
    private String tokenPassword;
    private Status status;
    private Set<Role> roles = new HashSet<>();
    private Cart cart;
    private PersonalInformation personalInformation;
}
