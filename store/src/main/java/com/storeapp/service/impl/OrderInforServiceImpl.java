package com.storeapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.storeapp.entity.LoginUser;
import com.storeapp.entity.OrderInfor;
import com.storeapp.entity.ResponseResult;
import com.storeapp.entity.Shoppingcart;
import com.storeapp.mapper.OrderInforMapper;
import com.storeapp.mapper.ShoppingcartMapper;
import com.storeapp.service.OrderInforService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.storeapp.vo.OrderInforVo;
import com.storeapp.vo.OrderListVo;
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
 * @since 2022-11-07
 */
@Service
public class OrderInforServiceImpl extends ServiceImpl<OrderInforMapper, OrderInfor> implements OrderInforService {
    @Autowired
    OrderInforMapper orderInforMapper;
    @Autowired
    ShoppingcartMapper shoppingcartMapper;

    @Override
    public ResponseResult getOrderList() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<OrderListVo> orderListVo = orderInforMapper.selectOrderListVo(loginUser.getUser().getId());
        return new ResponseResult(200,"请求成功",orderListVo);
    }

    @Override
    public ResponseResult getOrderInfor(Integer orderId) {
        OrderInforVo orderInforVo = orderInforMapper.selectOrderInforVo(orderId);
        return new ResponseResult(200,"请求成功",orderInforVo);

    }

    @Override
    public ResponseResult addOrder(List<OrderInfor> orderInforList) {
        if (!Objects.isNull(orderInforList)){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();
            for (OrderInfor orderInfor: orderInforList) {
                orderInfor.setUserId(loginUser.getUser().getId());
                orderInfor.setState(0);
                orderInforMapper.insert(orderInfor);

                QueryWrapper<Shoppingcart> shoppingcartQueryWrapper = new QueryWrapper<>();
                shoppingcartQueryWrapper.eq("id", orderInfor.getCartId());
                Shoppingcart shoppingcart = shoppingcartMapper.selectOne(shoppingcartQueryWrapper);
                shoppingcart.setIsorder(1);
                shoppingcartMapper.updateById(shoppingcart);
            }
            return new ResponseResult(200,"请求成功");
        }
        else {
            return new ResponseResult(200,"请求失败");
        }
    }

    @Override
    public ResponseResult Receipt(Integer orderId) {
        QueryWrapper<OrderInfor> orderInforQueryWrapper = new QueryWrapper<>();
        orderInforQueryWrapper.eq("id",orderId);
        OrderInfor orderInfor = orderInforMapper.selectOne(orderInforQueryWrapper);
        if (!Objects.isNull(orderInfor)){
            orderInfor.setState(1);
            orderInforMapper.updateById(orderInfor);
            return new ResponseResult(200,"请求成功");
        }
        else {
            return new ResponseResult(200,"请求失败");
        }
    }
}
