package com.dswjp.muebleria_miley_movil.catalog.model;

import com.dswjp.muebleria_miley_movil.catalog.model.color.ProductColor;
import com.dswjp.muebleria_miley_movil.catalog.model.feature.ProductFeature;
import com.dswjp.muebleria_miley_movil.catalog.model.image.DefaultProductImage;
import com.dswjp.muebleria_miley_movil.catalog.model.image.ProductImage;
import com.dswjp.muebleria_miley_movil.entity.CartItem;
import com.dswjp.muebleria_miley_movil.enums.AcquisitionType;
import com.dswjp.muebleria_miley_movil.purchase.model.PurchaseOrderDetail;
import com.dswjp.muebleria_miley_movil.purchase.model.Supplier;
import com.dswjp.muebleria_miley_movil.sales.model.order.OrderDetail;
import com.dswjp.muebleria_miley_movil.warehouse.model.InventoryMovements;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String id;

    private String name;
    private String description;
    private BigDecimal price;
    private AcquisitionType acquisitionType;
    private SubCategory subCategory;
    @Builder.Default
    private List<ProductFeature> features = new ArrayList<>();
    @Builder.Default
    private List<ProductColor> colors = new ArrayList<>();
    @Builder.Default
    private List<DefaultProductImage> images = new ArrayList<>();
    private List<CartItem> cartItems = new ArrayList<>();
    private List<OrderDetail> orderDetails = new ArrayList<>();
    private List<PurchaseOrderDetail> purchaseOrderDetails = new ArrayList<>();
    private List<InventoryMovements> inventoryMovements = new ArrayList<>();
    private Supplier supplier;
}
