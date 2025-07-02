package com.dswjp.muebleria_miley_movil.entity.catalog.feature;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feature {

    private String id;
    private String name;
    private List<ProductFeature> productFeatures = new ArrayList<>();
}
