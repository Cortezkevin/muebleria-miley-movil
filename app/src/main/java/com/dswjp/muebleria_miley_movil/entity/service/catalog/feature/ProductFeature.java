package com.dswjp.muebleria_miley_movil.entity.service.catalog.feature;

import com.dswjp.muebleria_miley_movil.entity.service.catalog.Product;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductFeature {

    private String id;
    private Product product;
    private Feature feature;
    private String value;
}
