package com.storeapp.service;

import com.storeapp.entity.ResponseResult;
import com.storeapp.entity.UserAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2022-11-07
 */
public interface UserAddressService extends IService<UserAddress> {

    public ResponseResult getAddress();
    public ResponseResult addAddress(UserAddress userAddress);
    public ResponseResult removeAddress(Integer userAddressId);
}
