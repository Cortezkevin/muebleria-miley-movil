package com.dswjp.muebleria_miley_movil.dto.catalog;

import java.math.BigDecimal;
import java.util.List;

public class ProductDTO {
    String id;
    String name;
    BigDecimal price;
    List<String> images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
