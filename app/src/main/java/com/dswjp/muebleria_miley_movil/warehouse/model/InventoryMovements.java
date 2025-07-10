package com.dswjp.muebleria_miley_movil.warehouse.model;

import com.dswjp.muebleria_miley_movil.catalog.model.Product;
import com.dswjp.muebleria_miley_movil.purchase.model.EntryGuide;
import com.dswjp.muebleria_miley_movil.purchase.model.RawMaterial;
import com.dswjp.muebleria_miley_movil.warehouse.enums.InventoryMovementType;

import java.sql.Timestamp;

public class InventoryMovements {

    private String id;
    private InventoryMovementType type;

    private Integer initialStock;
    private Integer amount;
    private Integer newStock;
    private Timestamp date;
    private String reason;
    private Product product;
    private RawMaterial rawMaterial;
    private Warehouse warehouse;
    private EntryGuide entryGuide;
    private ExitGuide exitGuide;
}
