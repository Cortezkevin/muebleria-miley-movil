package com.dswjp.muebleria_miley_movil.delivery.model;

import com.dswjp.muebleria_miley_movil.delivery.enums.CarrierStatus;
import com.dswjp.muebleria_miley_movil.sales.model.order.OrderShipping;
import com.dswjp.muebleria_miley_movil.security.model.User;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
    private String id;
    private String codePlate;
    private CarrierStatus status;
    private User user;
    private List<OrderShippingLocation> orderShippingLocations = new ArrayList<>();
    private List<OrderShipping> orderShipping = new ArrayList<>();
}
