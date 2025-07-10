package com.dswjp.muebleria_miley_movil.purchase.model;

import com.dswjp.muebleria_miley_movil.purchase.enums.MeasurementUnit;
import com.dswjp.muebleria_miley_movil.warehouse.model.InventoryMovements;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RawMaterial {

    private String id;

    private String name;
    private String description;
    private MeasurementUnit measurementUnit;
    private BigDecimal unitPrice = BigDecimal.ZERO;
    private Integer stock = 0;
    private List<PurchaseOrderDetail> purchaseOrderDetails = new ArrayList<>();
    private List<InventoryMovements> inventoryMovements = new ArrayList<>();
    private Supplier supplier;
}
