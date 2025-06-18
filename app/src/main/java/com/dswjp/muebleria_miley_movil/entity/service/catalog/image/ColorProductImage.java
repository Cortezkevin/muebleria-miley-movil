package com.dswjp.muebleria_miley_movil.entity.service.catalog.image;

import com.dswjp.muebleria_miley_movil.entity.service.catalog.color.ProductColor;

import lombok.*;


@Getter @Setter
@NoArgsConstructor
public class ColorProductImage extends ProductImage {

    private ProductColor productColor;

    public ColorProductImage(String url, String imageId, ProductColor productColor) {
        super(null, imageId, url);
        this.productColor = productColor;
    }
}
