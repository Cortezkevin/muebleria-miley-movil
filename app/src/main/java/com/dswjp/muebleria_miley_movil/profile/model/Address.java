package com.dswjp.muebleria_miley_movil.profile.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String id;
    private Double lta;
    private Double lng;
    private String department;
    private String province;
    private String district;
    private String urbanization;
    private String street;
    private Integer postalCode;
    private String fullAddress;
    private PersonalInformation personalInformation;

}
