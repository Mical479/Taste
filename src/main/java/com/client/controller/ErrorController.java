package com.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类 名 称：ErrorController
 * 类 描 述：TODO
 * 创建时间：2019/5/25 17:20
 * 创建人：Mical
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping("/404")
    public String error404(){
        return "error/404";
    }

    @GetMapping("/500")
    public String error500(){
        return "error/500";
    }
}
