package com.dswjp.muebleria_miley_movil.catalog.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String id;
    private String name;
    private String description;
    private String url_image;
    private List<SubCategory> subCategoryList = new ArrayList<>();

    public Category(String description, String id, String name, List<SubCategory> subCategoryList, String url_image) {
        this.description = description;
        this.id = id;
        this.name = name;
        this.url_image = url_image;
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

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<SubCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }
}
