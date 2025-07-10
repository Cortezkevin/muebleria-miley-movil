package com.dswjp.muebleria_miley_movil.catalog.model.feature;

import com.dswjp.muebleria_miley_movil.catalog.model.Product;

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
