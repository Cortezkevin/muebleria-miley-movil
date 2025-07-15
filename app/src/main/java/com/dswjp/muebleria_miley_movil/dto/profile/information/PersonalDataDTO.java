package com.dswjp.muebleria_miley_movil.dto.profile.information;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PersonalDataDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate birthdate;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
