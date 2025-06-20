package com.dswjp.muebleria_miley_movil.dto.catalog;

import com.dswjp.muebleria_miley_movil.entity.service.catalog.Category;

public class CategoryDTO {
    String id;
    String name;
    String description;
    String url_image;

    public CategoryDTO(String id, String name, String description, String urlImage) {
    }


    public static CategoryDTO toDTO(Category category){
        return new CategoryDTO(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getUrl_image()
        );
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }
}
