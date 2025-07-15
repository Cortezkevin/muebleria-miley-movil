package com.dswjp.muebleria_miley_movil.sales.dto.order;

import com.dswjp.muebleria_miley_movil.security.model.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserOrderDTO {
    String fullName;
    String email;
    String phone;

    public static UserOrderDTO toDTO(User user){
        return new UserOrderDTO(
                user.getPersonalInformation().getFullName(),
                user.getEmail(),
                user.getPersonalInformation().getPhone()
        );
    }
}
