package com.storeapp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.storeapp.entity.ResponseResult;
import com.storeapp.entity.User;

public interface LoginService extends IService<User> {
    public ResponseResult login(User user);
    public ResponseResult getuser();
    public ResponseResult logout();
    public ResponseResult signup(User user);
}
