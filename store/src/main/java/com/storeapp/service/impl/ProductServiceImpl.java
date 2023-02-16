package com.storeapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.storeapp.entity.Product;
import com.storeapp.entity.ResponseResult;
import com.storeapp.mapper.ProductMapper;
import com.storeapp.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2022-09-26
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseResult productList(Integer type) {
        QueryWrapper<Product> wrapper  = new QueryWrapper<>();
        if (type != null){
            wrapper.eq("type",type);
        }
        List<Product> productList = productMapper.selectList(wrapper);
        return new ResponseResult(200,"查询成功",productList);
    }

    @Override
    public ResponseResult productByName(String name) {
        QueryWrapper<Product> wrapper  = new QueryWrapper<>();
        if (name != null){
            wrapper.eq("name",name);
        }
        Product product = productMapper.selectOne(wrapper);
        return new ResponseResult(200,"查询成功",product);
    }
}
