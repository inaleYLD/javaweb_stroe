package com.storeapp.controller;


import com.storeapp.entity.ResponseResult;
import com.storeapp.entity.UserAddress;
import com.storeapp.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2022-11-07
 */
@RestController
@RequestMapping("/userAddress")
public class UserAddressController {
    @Autowired
    UserAddressService userAddressService;

    @RequestMapping("/getAddress")
    public ResponseResult getAddress(){
        return userAddressService.getAddress();
    }
    @RequestMapping("/addAddress")
    public ResponseResult addAddress(@RequestBody UserAddress userAddress){
        return userAddressService.addAddress(userAddress);
    }
    @RequestMapping("/removeAddress")
    public ResponseResult removeAddress(Integer userAddressId){
        return userAddressService.removeAddress(userAddressId);
    }
}

