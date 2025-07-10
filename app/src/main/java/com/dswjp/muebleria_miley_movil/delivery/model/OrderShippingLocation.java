package com.dswjp.muebleria_miley_movil.delivery.model;

import com.dswjp.muebleria_miley_movil.sales.model.order.OrderShipping;

import java.sql.Timestamp;

public class OrderShippingLocation {

    private String id;
    private Double lta;
    private Double lng;
    private Timestamp updatedAt;
    private Carrier carrier;
    private OrderShipping orderShipping;
}
