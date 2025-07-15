package com.dswjp.muebleria_miley_movil.sales.dto.order;

import com.dswjp.muebleria_miley_movil.sales.dto.order.preparation.OrderPreparationDTO;
import com.dswjp.muebleria_miley_movil.sales.dto.order.shipping.OrderShippingDTO;
import com.dswjp.muebleria_miley_movil.sales.enums.OrderStatus;
import com.dswjp.muebleria_miley_movil.sales.enums.PaymentMethod;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailedOrderDTO {
    String id;
    String note;
    BigDecimal subtotal;
    BigDecimal shippingCost;
    BigDecimal tax;
    BigDecimal discount;
    BigDecimal total;
    UserOrderDTO user;
    String shippingAddress;
    String specificAddress;
    Timestamp createdDate;
    Timestamp cancelledDate;
    Timestamp completedDate;
    PaymentMethod paymentMethod;
    OrderPreparationDTO preparation;
    OrderShippingDTO shipping;
    OrderStatus status;
    List<OrderDetailDTO> orderDetails;
    String invoiceUrl;
}
