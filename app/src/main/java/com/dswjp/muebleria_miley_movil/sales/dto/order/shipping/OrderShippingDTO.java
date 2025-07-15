package com.dswjp.muebleria_miley_movil.sales.dto.order.shipping;

import com.dswjp.muebleria_miley_movil.sales.enums.ShippingStatus;
import com.dswjp.muebleria_miley_movil.warehouse.dto.carrier.CarrierDTO;

import java.sql.Timestamp;

public class OrderShippingDTO {
    String id;
    String userIdFromCarrier;
    String orderId;
    CarrierDTO carrier;
    String preparedBy;
    String address;
    Timestamp createdDate;
    Timestamp startDate;
    Timestamp preparedDate;
    Timestamp shippingDate;
    Timestamp completedDate;
    ShippingStatus status;
}
