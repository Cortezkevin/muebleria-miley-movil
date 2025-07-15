package com.dswjp.muebleria_miley_movil.sales.model.order;

import com.dswjp.muebleria_miley_movil.catalog.model.Product;

import java.math.BigDecimal;

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
public class OrderDetail {
    private String id;
    private String name;
    private BigDecimal price;
    private Integer amount;
    private BigDecimal total;
    private Order order;
    private Product product;
}
