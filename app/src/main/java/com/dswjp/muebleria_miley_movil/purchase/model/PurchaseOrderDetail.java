package com.dswjp.muebleria_miley_movil.purchase.model;

import com.dswjp.muebleria_miley_movil.catalog.model.Product;
import com.dswjp.muebleria_miley_movil.purchase.enums.PurchaseOrderDetailStatus;

import java.math.BigDecimal;

public class PurchaseOrderDetail {

    private String id;

    private Integer amount;
    private BigDecimal unitPrice;
    private BigDecimal total;
    private PurchaseOrderDetailStatus status;
    private RawMaterial rawMaterial;
    private Product product;
    private PurchaseOrder purchaseOrder;
}
