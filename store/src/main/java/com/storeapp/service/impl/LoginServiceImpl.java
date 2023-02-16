package com.storeapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.storeapp.entity.LoginUser;
import com.storeapp.entity.ResponseResult;
import com.storeapp.entity.User;
import com.storeapp.mapper.UserMapper;
import com.storeapp.service.LoginService;
import com.storeapp.utils.JwtUtil;

import com.storeapp.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, User> implements LoginService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    RedisCache redisCache;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getAccount(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误！");
        }

        LoginUser loginUser= (LoginUser)(authenticate.getPrincipal());
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        Map<String,String> map=new HashMap();
        map.put("token",jwt);
        redisCache.setCacheObject("login:"+userId,loginUser);
        return new ResponseResult(200,"登陆成功",map);
    }

    @Override

    public ResponseResult getuser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        loginUser.getUser().setPassword(null);
        return new ResponseResult(200,"请求成功",loginUser.getUser());
    }

    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        redisCache.deleteObject("login:"+userId);
        return new ResponseResult(200,"退出成功！");
    }

    @Override
    public ResponseResult signup(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userMapper.selectOne(new QueryWrapper<User>().eq("account",user.getAccount())) == null){
            userMapper.insert(user);
            return new ResponseResult(200,"注册成功");
        }
        else {
            return new ResponseResult(200,"注册失败");
        }
    }
}
