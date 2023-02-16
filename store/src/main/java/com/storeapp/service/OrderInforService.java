package com.storeapp.service;

import com.storeapp.entity.OrderInfor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.storeapp.entity.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2022-11-07
 */
public interface OrderInforService extends IService<OrderInfor> {
    public ResponseResult getOrderList();
    public ResponseResult getOrderInfor(Integer orderId);
    public ResponseResult addOrder(List<OrderInfor> orderInforList);
    public ResponseResult Receipt(Integer orderId);
}
