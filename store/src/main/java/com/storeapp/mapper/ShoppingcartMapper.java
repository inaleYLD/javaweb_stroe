package com.storeapp.mapper;

import com.storeapp.vo.CartProductVo;
import com.storeapp.entity.Shoppingcart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2022-10-17
 */
public interface ShoppingcartMapper extends BaseMapper<Shoppingcart> {
    public List<CartProductVo> selectCart(Integer id);
/*    public List<Shoppingcart> selectByuserid(Integer id);*/
}
