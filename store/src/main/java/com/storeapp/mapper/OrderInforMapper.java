package com.storeapp.mapper;

import com.storeapp.entity.OrderInfor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.storeapp.vo.OrderInforVo;
import com.storeapp.vo.OrderListVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2022-11-07
 */
public interface OrderInforMapper extends BaseMapper<OrderInfor> {
    public OrderInforVo selectOrderInforVo(Integer orderId);
    public List<OrderListVo> selectOrderListVo(Integer userId);
}
