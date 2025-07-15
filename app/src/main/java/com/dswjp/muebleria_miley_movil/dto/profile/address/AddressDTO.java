package com.dswjp.muebleria_miley_movil.dto.profile.address;

import lombok.Data;

@Data
public class AddressDTO {
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
}
