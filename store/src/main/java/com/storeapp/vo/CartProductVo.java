package com.storeapp.vo;

import lombok.Data;

@Data
public class CartProductVo {
    private Integer cartId;
    private String name;
    private Integer price;
    private String image;
    private Integer quantity;
}
