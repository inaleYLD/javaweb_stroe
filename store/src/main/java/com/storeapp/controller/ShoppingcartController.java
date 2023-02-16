package com.storeapp.controller;


import com.storeapp.entity.LoginUser;
import com.storeapp.entity.ResponseResult;
import com.storeapp.service.ShoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2022-10-17
 */
@RestController
@RequestMapping("/shoppingcart")
public class ShoppingcartController {
    @Autowired
    private ShoppingcartService shoppingcartService;

    @RequestMapping("/getCart")
    public ResponseResult getCart(){
        return shoppingcartService.getCart();
    }
    @RequestMapping("/addProduct")
    public ResponseResult addProduct(Integer productId){
        return shoppingcartService.addProduct(productId);
    }
    @RequestMapping("/removeProduct")
    public ResponseResult removeProduct(Integer cartId){
        return shoppingcartService.removeProduct(cartId);
    }
}

