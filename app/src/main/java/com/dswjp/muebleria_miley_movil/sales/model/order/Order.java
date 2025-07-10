package com.dswjp.muebleria_miley_movil.sales.model.order;

import com.dswjp.muebleria_miley_movil.sales.enums.OrderStatus;
import com.dswjp.muebleria_miley_movil.sales.enums.PaymentMethod;
import com.dswjp.muebleria_miley_movil.security.model.User;
import com.dswjp.muebleria_miley_movil.warehouse.model.ExitGuide;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {

    private String id;

    private String note;
    private String shippingAddress;
    private String specificAddress;
    private BigDecimal shippingCost;
    private Double distance = 0.0;
    private BigDecimal tax;
    private BigDecimal discount;
    private BigDecimal subtotal;
    private BigDecimal total;
    private User user;
    private Timestamp createdDate;
    private Timestamp cancelledDate;
    private Timestamp completedDate;
    private PaymentMethod paymentMethod;
    private OrderShipping orderShipping;
    private OrderPreparation orderPreparation;
    private OrderStatus status;
    private Invoice invoice;
    private ExitGuide exitGuide;
}
