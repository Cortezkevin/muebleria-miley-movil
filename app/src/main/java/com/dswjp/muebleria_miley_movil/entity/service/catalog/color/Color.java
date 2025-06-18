package com.dswjp.muebleria_miley_movil.entity.service.catalog.color;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Color {

    private String id;
    private String color;
    private List<ProductColor> productColors = new ArrayList<>();
}
