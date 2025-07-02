package com.dswjp.muebleria_miley_movil.entity;

import com.dswjp.muebleria_miley_movil.entity.catalog.Product;

import java.math.BigDecimal;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    private String id;
    private Integer amount;
    private BigDecimal total;
    private Cart cart;
    private Product product;
}
