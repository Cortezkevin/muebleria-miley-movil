package com.dswjp.muebleria_miley_movil.entity.service.catalog;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory {

    private String id;
    private String name;
    private String description;
    private String url_image;
    private Category category;
    private List<Product> productList = new ArrayList<>();
}
