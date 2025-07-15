package com.dswjp.muebleria_miley_movil.catalog.model.color;

import com.dswjp.muebleria_miley_movil.catalog.model.Product;
import com.dswjp.muebleria_miley_movil.catalog.model.image.ColorProductImage;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductColor {
    private String id;
    private Product product;
    private Color color;
    private Integer stock;
    private List<ColorProductImage> images = new ArrayList<>();
}
