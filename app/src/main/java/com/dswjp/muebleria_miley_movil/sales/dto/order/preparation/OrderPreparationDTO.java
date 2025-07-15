package com.dswjp.muebleria_miley_movil.sales.dto.order.preparation;

import com.dswjp.muebleria_miley_movil.sales.enums.OrderStatus;
import com.dswjp.muebleria_miley_movil.sales.enums.PreparationStatus;
import com.dswjp.muebleria_miley_movil.warehouse.dto.GrocerDTO;

import java.sql.Timestamp;

public class OrderPreparationDTO {
    String id;
    String userIdFromGrocer;
    String orderId;
    GrocerDTO grocer;
    Timestamp createdDate;
    Timestamp startDate;
    Timestamp preparedDate;
    Timestamp completedDate;
    OrderStatus orderStatus;
    PreparationStatus status;
}
