package com.dswjp.muebleria_miley_movil.dto.sales;

import com.dswjp.muebleria_miley_movil.enums.sales.OrderStatus;
import com.dswjp.muebleria_miley_movil.enums.sales.PaymentMethod;
import com.dswjp.muebleria_miley_movil.enums.sales.PreparationStatus;
import com.dswjp.muebleria_miley_movil.enums.sales.ShippingStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderDTO {
    String id;
    BigDecimal total;
    String user;
    String shippingAddress;
    Timestamp createdDate;
    Timestamp cancelledDate;
    Timestamp completedDate;
    PaymentMethod paymentMethod;
    PreparationStatus preparationStatus;
    ShippingStatus shippingStatus;
    OrderStatus status;
}
