package com.dswjp.muebleria_miley_movil.warehouse.model;

import com.dswjp.muebleria_miley_movil.purchase.model.EntryGuide;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private String id;
    private String location;
    List<InventoryMovements> inventoryMovements = new ArrayList<>();
    List<EntryGuide> entryGuides = new ArrayList<>();
    List<ExitGuide> exitGuides = new ArrayList<>();
}
