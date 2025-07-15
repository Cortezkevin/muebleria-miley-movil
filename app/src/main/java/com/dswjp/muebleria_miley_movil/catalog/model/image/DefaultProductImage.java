package com.dswjp.muebleria_miley_movil.catalog.model.image;

import com.dswjp.muebleria_miley_movil.catalog.model.Product;

import lombok.*;


@Getter @Setter
@NoArgsConstructor
public class DefaultProductImage extends ProductImage {
    private Product product;
    public DefaultProductImage( String url, String imageId, Product product) {
        super(null,imageId, url);
        this.product = product;
    }
}
