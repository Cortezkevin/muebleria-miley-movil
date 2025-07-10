package com.dswjp.muebleria_miley_movil.purchase.model;

import com.dswjp.muebleria_miley_movil.warehouse.model.Grocer;
import com.dswjp.muebleria_miley_movil.warehouse.model.InventoryMovements;
import com.dswjp.muebleria_miley_movil.warehouse.model.Warehouse;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EntryGuide {
    private String id;

    private Timestamp date;
    private String productConditions;
    private Grocer grocer;
    private PurchaseOrder purchaseOrder;
    private Warehouse warehouse;
    private List<InventoryMovements> inventoryMovementsList = new ArrayList<>();
}
