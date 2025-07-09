package com.dswjp.muebleria_miley_movil.entity.catalog.feature;

import com.dswjp.muebleria_miley_movil.entity.catalog.Product;

import lombok.*;

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
