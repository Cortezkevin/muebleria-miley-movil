package com.dswjp.muebleria_miley_movil.entity.service.catalog;

import com.dswjp.muebleria_miley_movil.entity.service.catalog.feature.ProductFeature;
import com.dswjp.muebleria_miley_movil.entity.service.catalog.image.DefaultProductImage;
import com.dswjp.muebleria_miley_movil.entity.service.catalog.image.ProductImage;
import com.dswjp.muebleria_miley_movil.enums.AcquisitionType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String id;

    private String name;
    private String description;
    private BigDecimal price;
    private AcquisitionType acquisitionType;
    private SubCategory subCategory;
    @Builder.Default
    private List<ProductFeature> features = new ArrayList<>();
    @Builder.Default
    private List<ProductImage> colors = new ArrayList<>();
    @Builder.Default
    private List<DefaultProductImage> images = new ArrayList<>();
}
