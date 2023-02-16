package com.storeapp.vo;

import lombok.Data;

@Data
public class OrderListVo {
    private Integer orderId;
    private Integer state;
    private String image;
    private String name;
    private Integer price;
    private Integer quantity;
}
