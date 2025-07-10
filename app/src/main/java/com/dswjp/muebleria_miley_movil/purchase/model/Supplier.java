package com.dswjp.muebleria_miley_movil.purchase.model;

import com.dswjp.muebleria_miley_movil.catalog.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
    private String id;
    private String name;
    private String ruc;
    private String phone;
    private String address;
    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();
    private List<RawMaterial> rawMaterialList = new ArrayList<>();
}
