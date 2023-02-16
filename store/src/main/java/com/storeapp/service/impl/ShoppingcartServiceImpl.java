package com.storeapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.storeapp.entity.LoginUser;
import com.storeapp.entity.ResponseResult;
import com.storeapp.entity.Shoppingcart;
import com.storeapp.mapper.ShoppingcartMapper;
import com.storeapp.service.ShoppingcartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.storeapp.vo.CartProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2022-10-17
 */
@Service
public class ShoppingcartServiceImpl extends ServiceImpl<ShoppingcartMapper, Shoppingcart> implements ShoppingcartService {

    @Autowired
    ShoppingcartMapper shoppingcartMapper;
    @Override
    public ResponseResult getCart() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<CartProductVo> cartProductVos = shoppingcartMapper.selectCart(loginUser.getUser().getId());
        return new ResponseResult(200,"请求成功",cartProductVos);
    }

    @Override
    public ResponseResult addProduct(Integer productId) {
        QueryWrapper<Shoppingcart> shoppingcartQueryWrapper = new QueryWrapper<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        shoppingcartQueryWrapper.eq("product_id",productId);
        shoppingcartQueryWrapper.eq("user_id",loginUser.getUser().getId());
        shoppingcartQueryWrapper.eq("isorder",0);
        Shoppingcart shoppingcart = shoppingcartMapper.selectOne(shoppingcartQueryWrapper);

        if (Objects.isNull(shoppingcart)){
            shoppingcart = new Shoppingcart();
            shoppingcart.setUserId(loginUser.getUser().getId());
            shoppingcart.setProductId(productId);
            shoppingcart.setQuantity(1);
            shoppingcart.setIsorder(0);
            shoppingcartMapper.insert(shoppingcart);
            return new ResponseResult(200,"添加成功");
        }
        else {
            shoppingcart.setQuantity(shoppingcart.getQuantity().intValue()+1);
            shoppingcartMapper.update(shoppingcart,shoppingcartQueryWrapper);
            return new ResponseResult(200,"添加成功!");
        }

    }

    @Override
    public ResponseResult removeProduct(Integer cartId) {
        QueryWrapper<Shoppingcart> shoppingcartQueryWrapper = new QueryWrapper<>();
/*        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        shoppingcartQueryWrapper.eq("product_id",productId);*/
        shoppingcartQueryWrapper.eq("id",cartId);
        shoppingcartQueryWrapper.eq("isorder",0);
        if (shoppingcartMapper.delete(shoppingcartQueryWrapper) != 0){
            return new ResponseResult(200,"删除成功");
        }
        else {
            return new ResponseResult(200,"删除失败");
        }
    }
}
