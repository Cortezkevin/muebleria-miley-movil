package com.dswjp.muebleria_miley_movil.purchase.model;

import com.dswjp.muebleria_miley_movil.purchase.enums.PurchaseOrderReceptionStatus;
import com.dswjp.muebleria_miley_movil.warehouse.model.Grocer;

import java.sql.Timestamp;

public class PurchaseOrderReception {

    private String id;

    private String observations;
    private Timestamp createdDate;
    private Timestamp startDate;
    private Timestamp reviewDate;
    private Timestamp completedDate;
    private PurchaseOrderReceptionStatus status;
    private Grocer grocer;
    private PurchaseOrder purchaseOrder;
}
