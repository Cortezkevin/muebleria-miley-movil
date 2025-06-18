package com.dswjp.muebleria_miley_movil.entity.service;

import com.dswjp.muebleria_miley_movil.entity.service.security.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    private String id;
    private BigDecimal tax = BigDecimal.ZERO;
    private BigDecimal discount = BigDecimal.ZERO;
    private BigDecimal subtotal = BigDecimal.ZERO;
    private BigDecimal shippingCost = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;
    private List<CartItem> cartItems = new ArrayList<>();
    private User user;
}
