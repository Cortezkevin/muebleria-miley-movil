package com.dswjp.muebleria_miley_movil.warehouse.model;

import com.dswjp.muebleria_miley_movil.sales.model.order.Order;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ExitGuide {
    private String id;
    private Timestamp date;
    private String observations;
    private Grocer grocer;
    private Order order;
    private Warehouse warehouse;
    private List<InventoryMovements> inventoryMovementsList = new ArrayList<>();
}
