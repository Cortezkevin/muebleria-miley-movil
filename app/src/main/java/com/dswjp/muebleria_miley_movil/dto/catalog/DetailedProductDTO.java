package com.dswjp.muebleria_miley_movil.dto.catalog;

import com.dswjp.muebleria_miley_movil.enums.AcquisitionType;

import java.math.BigDecimal;
import java.util.List;

public class DetailedProductDTO {
    String id;
    String name;
    String description;
    String category;
    String subcategory;
    BigDecimal price;
    List<String> images;
    List<ProductColorDTO> colors;
    List<ProductFeatureDTO> features;
    AcquisitionType acquisitionType;
}
