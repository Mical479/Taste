package com.client.controller;

import com.client.mapper.BussinessUserMapper;
import com.client.pojo.BussinessUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 类 名 称：MyController
 * 类 描 述：首页引导页面
 * 创建时间：2019/5/25 9:49
 * 创建人：Mical
 */
@Controller
public class MyController {

    @Autowired
    private BussinessUserMapper bussinessUserMapper;

    @GetMapping("/")
    public String toIndexPage() {
        return "index";
    }

    @GetMapping("/login")
    public String toLoginPage() {
        return "client/login";
    }


    @PostMapping("/loginto")
    public String LoginToClient(@RequestParam("name") String username,
                              @RequestParam("password") String password,
                              HttpServletRequest request) {
        BussinessUser bussinessUser = bussinessUserMapper.selectByNickName(username);
        if (bussinessUser != null && bussinessUser.getPassword().equals(password)) {
            request.getSession().setAttribute("user", bussinessUser);
            return "client/index";
        }else {
            return "client/login";
        }
    }
}
