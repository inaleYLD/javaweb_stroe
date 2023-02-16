package com.storeapp.service;

import com.storeapp.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.storeapp.entity.ResponseResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2022-09-26
 */
public interface ProductService extends IService<Product> {
    public ResponseResult productList(Integer type);
    public ResponseResult productByName(String name);
}
