package com.storeapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.storeapp.entity.LoginUser;
import com.storeapp.entity.ResponseResult;
import com.storeapp.entity.UserAddress;
import com.storeapp.mapper.UserAddressMapper;
import com.storeapp.service.UserAddressService;
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
 * @since 2022-11-07
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {
    @Autowired
    UserAddressMapper userAddressMapper;

    @Override
    public ResponseResult getAddress() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        QueryWrapper<UserAddress> userAddressQueryWrapper = new QueryWrapper<>();
        userAddressQueryWrapper.eq("user_id",loginUser.getUser().getId());
        userAddressQueryWrapper.eq("_delete",0);
        List<UserAddress> userAddressList = userAddressMapper.selectList(userAddressQueryWrapper);
        return new ResponseResult(200,"请求成功",userAddressList);
    }

    @Override
    public ResponseResult addAddress(UserAddress userAddress) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        if (!Objects.isNull(userAddress)){
            userAddress.setUserId(loginUser.getUser().getId());
            userAddress.set_delete(1);
            userAddressMapper.insert(userAddress);
            return new ResponseResult(200,"添加成功");
        }
        else {
            return new ResponseResult(200,"添加失败");
        }
    }

    @Override
    public ResponseResult removeAddress(Integer userAddressId) {
        QueryWrapper<UserAddress> userAddressQueryWrapper = new QueryWrapper<>();
        userAddressQueryWrapper.eq("id",userAddressId);
        UserAddress userAddress = userAddressMapper.selectOne(userAddressQueryWrapper);
        userAddress.set_delete(0);
        userAddressMapper.updateById(userAddress);
        return new ResponseResult(200,"移除成功");
    }
}
