package com.dswjp.muebleria_miley_movil.sales.dto.order;

import com.dswjp.muebleria_miley_movil.catalog.model.Product;
import com.dswjp.muebleria_miley_movil.catalog.model.image.ProductImage;
import com.dswjp.muebleria_miley_movil.sales.model.order.OrderDetail;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderDetailDTO {
    String id;
    String image;
    String name;
    BigDecimal price;
    Integer amount;
    BigDecimal total;

    public static OrderDetailDTO toDTO(OrderDetail orderDetail){
        return new OrderDetailDTO(
                orderDetail.getId(),
                getImagesFromDefaultOrColor(orderDetail.getProduct()).get(0),
                orderDetail.getName(),
                orderDetail.getPrice(),
                orderDetail.getAmount(),
                orderDetail.getTotal()
        );
    }

    private static List<String> getImagesFromDefaultOrColor(Product product){
        return product.getImages() != null && !product.getImages().isEmpty()
                ? product.getImages().stream().map(ProductImage::getUrl).collect(Collectors.toList())
                : product.getColors().get(0).getImages().stream().map(ProductImage::getUrl).collect(Collectors.toList());
    }
}
