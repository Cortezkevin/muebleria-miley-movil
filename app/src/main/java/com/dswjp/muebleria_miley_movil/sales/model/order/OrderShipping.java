package com.dswjp.muebleria_miley_movil.sales.model.order;

import com.dswjp.muebleria_miley_movil.delivery.model.Carrier;
import com.dswjp.muebleria_miley_movil.delivery.model.OrderShippingLocation;
import com.dswjp.muebleria_miley_movil.sales.enums.ShippingStatus;

import java.sql.Timestamp;

public class OrderShipping {

    private String id;
    private String address;
    private String preparedBy;
    private Double distance = 0.0;
    private Double destinationLat;
    private Double destinationLng;
    private Timestamp createdDate;
    private Timestamp startDate;
    private Timestamp preparedDate;
    private Timestamp shippingDate;
    private Timestamp completedDate;
    private OrderShippingLocation shippingLocation;
    private Carrier carrier;
    private ShippingStatus status;
    private Order order;
}
