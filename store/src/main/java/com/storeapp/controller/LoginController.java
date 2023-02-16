package com.storeapp.controller;

import com.storeapp.entity.ResponseResult;
import com.storeapp.entity.User;
import com.storeapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public ResponseResult login(@RequestBody User user){
        return loginService.login(user);
    }
    @RequestMapping("/getuser")
    public ResponseResult getuser(){
        return loginService.getuser();
    }
    @RequestMapping("/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
    @RequestMapping("signup")
    public ResponseResult signup(@RequestBody User user) {
        return loginService.signup(user);
    }
}
