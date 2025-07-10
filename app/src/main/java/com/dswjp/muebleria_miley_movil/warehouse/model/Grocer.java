package com.dswjp.muebleria_miley_movil.warehouse.model;

import com.dswjp.muebleria_miley_movil.purchase.model.PurchaseOrderReception;
import com.dswjp.muebleria_miley_movil.sales.model.order.OrderPreparation;
import com.dswjp.muebleria_miley_movil.security.model.User;
import com.dswjp.muebleria_miley_movil.warehouse.enums.GrocerStatus;

import java.util.ArrayList;
import java.util.List;

public class Grocer {

    private String id;
    private GrocerStatus status;
    private User user;
    private List<OrderPreparation> orderPreparations = new ArrayList<>();
    private List<PurchaseOrderReception> purchaseOrderReceptions = new ArrayList<>();
}
