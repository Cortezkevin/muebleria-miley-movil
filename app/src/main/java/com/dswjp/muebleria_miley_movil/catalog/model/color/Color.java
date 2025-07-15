package com.dswjp.muebleria_miley_movil.catalog.model.color;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
