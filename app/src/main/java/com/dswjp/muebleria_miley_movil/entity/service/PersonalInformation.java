package com.dswjp.muebleria_miley_movil.entity.service;

import com.dswjp.muebleria_miley_movil.entity.service.security.User;

import java.time.LocalDate;

import lombok.*;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInformation {
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate birthdate;
    private User user;
    private Address address;
}
