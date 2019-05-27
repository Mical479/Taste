package com.client.service;

import com.client.mapper.OrderMapper;
import com.client.pojo.OrderPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 类 名 称：OrderService
 * 类 描 述：订单相关操作
 * 创建时间：2019/5/25 23:01
 * 创建人：Mical
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 用户下单
     * @param orderPojo 订单对象
     */
    @Transactional
    public void insertOrder(OrderPojo orderPojo){
        orderPojo.setOrderTime(new Date());
        String orderId = orderPojo.getUserId()+""+new Date().getTime();
        orderPojo.setOrderId(orderId);
        orderPojo.setOrderStatus(0);
        orderPojo.setRowNumbers(2);
        orderPojo.setMealTime(new Date());
        orderMapper.insertOrder(orderPojo);
    }
}
