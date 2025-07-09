package com.dswjp.muebleria_miley_movil.entity.catalog.color;

import com.dswjp.muebleria_miley_movil.entity.catalog.Product;
import com.dswjp.muebleria_miley_movil.entity.catalog.image.ColorProductImage;

import java.util.ArrayList;
import java.util.List;

import lombok.*;


public class ProductColor {
    private String id;
    private Product product;
    private Color color;
    private Integer stock;

    private List<ColorProductImage> images = new ArrayList<>();

    public ProductColor() {
    }

    public ProductColor(Color color, String id, Product product, List<ColorProductImage> images, Integer stock) {
        this.color = color;
        this.id = id;
        this.product = product;
        this.images = images;
        this.stock = stock;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ColorProductImage> getImages() {
        return images;
    }

    public void setImages(List<ColorProductImage> images) {
        this.images = images;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
