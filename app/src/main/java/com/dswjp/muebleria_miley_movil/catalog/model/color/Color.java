package com.dswjp.muebleria_miley_movil.catalog.model.color;

import java.util.ArrayList;
import java.util.List;

public class Color {

    private String id;
    private String color;
    private List<ProductColor> productColors = new ArrayList<>();

    public Color() {
    }

    public Color(String color, String id, List<ProductColor> productColors) {
        this.color = color;
        this.id = id;
        this.productColors = productColors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProductColor> getProductColors() {
        return productColors;
    }

    public void setProductColors(List<ProductColor> productColors) {
        this.productColors = productColors;
    }
}
