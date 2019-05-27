package com.tastes.controller;

import com.client.pojo.OrderPojo;
import com.client.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类 名 称：OrderController
 * 类 描 述：处理订单相关
 * 创建时间：2019/5/26 21:52
 * 创建人：Mical
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/getOrder")
    public void getOreder(@RequestParam("userId") Integer userId,
                          @RequestParam("shopId") Integer shopId,
                          @RequestParam("tableType") Integer tableType,
                          @RequestParam("userCount") Integer userCount){
        OrderPojo order = new OrderPojo();
        order.setUserId(userId);
        order.setShopId(shopId);
        order.setUserCount(userCount);
        order.setRemark(tableType+"");
        orderService.insertOrder(order);
    }
}
