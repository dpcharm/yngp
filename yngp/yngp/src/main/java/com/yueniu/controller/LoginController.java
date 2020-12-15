package com.yueniu.controller;


import com.yueniu.dao.LoginMapper;
import com.yueniu.model.User;
import com.yueniu.service.LoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;


    @RequestMapping("/login")
    public String login(){

        List<User> list = loginService.getAllUser();

        System.out.println(list);

        return "12312313";
    }
}
