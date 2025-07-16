package com.dswjp.muebleria_miley_movil.dto.profile.information;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class PersonalDataDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String birthdate;

    public static PersonalDataDTO empty(){
        return new PersonalDataDTO(
                "",
                "",
                "" ,
                        null
        );
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
