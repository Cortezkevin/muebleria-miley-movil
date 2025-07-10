package com.dswjp.muebleria_miley_movil.purchase.model;

import com.dswjp.muebleria_miley_movil.warehouse.model.Grocer;

import java.sql.Timestamp;

public class RejectionGuide {
    private String id;
    private Timestamp date;
    private String reason;
    private String productConditions;
    private String suggestions;
    private Grocer grocer;
    private PurchaseOrder purchaseOrder;
}
