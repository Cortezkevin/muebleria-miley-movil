package com.dswjp.muebleria_miley_movil.purchase.model;

import com.dswjp.muebleria_miley_movil.purchase.enums.PurchaseOrderStatus;
import com.dswjp.muebleria_miley_movil.security.model.User;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrder {
    private String id;
    private Timestamp date;
    private PurchaseOrderStatus status;
    private BigDecimal total;
    private User user;
    private Supplier supplier;
    private PurchaseOrderReception purchaseOrderReception;
    private EntryGuide entryGuide;
    private RejectionGuide rejectionGuide;
    private List<PurchaseOrderDetail> purchaseOrderDetails = new ArrayList<>();
}
