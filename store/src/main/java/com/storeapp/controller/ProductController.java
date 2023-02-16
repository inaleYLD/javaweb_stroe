package com.storeapp.controller;


import com.storeapp.entity.Product;
import com.storeapp.entity.ResponseResult;
import com.storeapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2022-09-26
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/productList")
    public ResponseResult productList(Integer type){
        return productService.productList(type);
    }
    @GetMapping("/productOne")
    public ResponseResult product(String name){
        return productService.productByName(name);
    }
}

