package com.storeapp.service;

import com.storeapp.entity.ResponseResult;
import com.storeapp.entity.Shoppingcart;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2022-10-17
 */
public interface ShoppingcartService extends IService<Shoppingcart> {
    public ResponseResult getCart();
    public ResponseResult addProduct(Integer productId);
    public ResponseResult removeProduct(Integer cartId);
}
