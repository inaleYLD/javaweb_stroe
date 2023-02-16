package com.storeapp.vo;

import lombok.Data;

@Data
public class OrderInforVo {
    private Integer cartId;
    private Integer state;
    private String productName;
    private Integer productPrice;
    private Integer quantity;
    private String addressee;
    private String phoneNum;
    private String address;
}
