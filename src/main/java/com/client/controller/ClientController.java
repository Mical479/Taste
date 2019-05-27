package com.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 类 名 称：First
 * 类 描 述：TODO
 * 创建时间：2019/5/24 20:33
 * 创建人：Mical
 */
@Controller
public class ClientController {

    @GetMapping("/client/index")
    public String index(){
        return "client/index"; //当浏览器输入/index时，会返回 /templates/home.html页面
    }

    @GetMapping("/client/layout")
    public String Layoout(){
        return "client/layouts-fixed-sidebar";
    }
}
