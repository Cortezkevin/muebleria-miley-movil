package com.dswjp.muebleria_miley_movil.sales.model.order;

import com.dswjp.muebleria_miley_movil.sales.enums.PreparationStatus;
import com.dswjp.muebleria_miley_movil.warehouse.model.Grocer;

import java.sql.Timestamp;

public class OrderPreparation {

    private String id;
    private Timestamp createdDate;
    private Timestamp startDate;
    private Timestamp preparedDate;
    private Timestamp completedDate;
    private PreparationStatus status;
    private Grocer grocer;
    private Order order;
}
