package com.dswjp.muebleria_miley_movil.catalog.model.image;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ProductImage {

    protected String id;
    protected String image_id;
    protected String url;

    public ProductImage(Object o, String imageId, String url) {
    }
}
