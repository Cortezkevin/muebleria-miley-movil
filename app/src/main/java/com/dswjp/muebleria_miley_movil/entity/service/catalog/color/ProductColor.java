package com.dswjp.muebleria_miley_movil.entity.service.catalog.color;

import com.dswjp.muebleria_miley_movil.entity.service.catalog.Product;
import com.dswjp.muebleria_miley_movil.entity.service.catalog.image.ColorProductImage;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductColor {
    private String id;
    private Product product;
    private Color color;
    private Integer stock;
    @Builder.Default
    private List<ColorProductImage> images = new ArrayList<>();
}
