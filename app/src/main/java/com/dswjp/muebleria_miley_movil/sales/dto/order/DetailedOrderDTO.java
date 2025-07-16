package com.dswjp.muebleria_miley_movil.sales.dto.order;

import com.dswjp.muebleria_miley_movil.sales.dto.order.preparation.OrderPreparationDTO;
import com.dswjp.muebleria_miley_movil.sales.dto.order.shipping.OrderShippingDTO;
import com.dswjp.muebleria_miley_movil.sales.enums.OrderStatus;
import com.dswjp.muebleria_miley_movil.sales.enums.PaymentMethod;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DetailedOrderDTO {
    private String id;
    private String note;
    private BigDecimal subtotal;
    private BigDecimal shippingCost;
    private BigDecimal tax;
    private BigDecimal discount;
    private BigDecimal total;
    private UserOrderDTO user;
    private String shippingAddress;
    private String specificAddress;
    private Timestamp createdDate;
    private Timestamp cancelledDate;
    private Timestamp completedDate;
    private PaymentMethod paymentMethod;
    private OrderPreparationDTO preparation;
    private OrderShippingDTO shipping;
    private OrderStatus status;
    private List<OrderDetailDTO> orderDetails;
    private String invoiceUrl;
}
