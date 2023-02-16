package com.storeapp.controller;


import com.storeapp.entity.OrderInfor;
import com.storeapp.entity.ResponseResult;
import com.storeapp.service.OrderInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2022-11-07
 */
@RestController
@RequestMapping("/orderInfor")
public class OrderInforController {
    @Autowired
    OrderInforService orderInforService;

    @RequestMapping("/getOrderList")
    public ResponseResult getOrderList() {
        return orderInforService.getOrderList();
    }
    @RequestMapping("/getOrderInfor")
    public ResponseResult getOrderInfor(Integer orderId) {
        return orderInforService.getOrderInfor(orderId);
    }
    @RequestMapping("/addOrder")
    public ResponseResult addOrder(@RequestBody List<OrderInfor> orderInforList) {
        return orderInforService.addOrder(orderInforList);
    }
    @RequestMapping("/receipt")
    public ResponseResult Receipt(Integer orderId) {
        return orderInforService.Receipt(orderId);
    }

}

