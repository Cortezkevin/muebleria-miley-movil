package com.dswjp.muebleria_miley_movil.dto.sales;

import com.dswjp.muebleria_miley_movil.sales.enums.OrderStatus;
import com.dswjp.muebleria_miley_movil.sales.enums.PaymentMethod;
import com.dswjp.muebleria_miley_movil.sales.enums.PreparationStatus;
import com.dswjp.muebleria_miley_movil.sales.enums.ShippingStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderDTO {
    private String id;
    private BigDecimal total;
    private String user;
    private String shippingAddress;
    private Timestamp createdDate;
    private Timestamp cancelledDate;
    private Timestamp completedDate;
    private PaymentMethod paymentMethod;
    private PreparationStatus preparationStatus;
    private ShippingStatus shippingStatus;
    private OrderStatus status;
}
