package com.client.mapper;

import com.client.pojo.OrderPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 类 名 称：OrderPojoMapperTest
 * 类 描 述：TODO
 * 创建时间：2019/5/25 23:07
 * 创建人：Mical
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderPojoMapperTest {

    @Autowired
    OrderMapper orderMapper;

    @Test
    public void test(){
        OrderPojo orderPojo = new OrderPojo();
        orderPojo.setUserId(1);
        orderPojo.setMealTime(new Date());
        orderPojo.setOrderStatus(0);
        orderPojo.setOrderTime(new Date());
        orderPojo.setRemark("ni好");
        orderPojo.setShopId(2);
        orderPojo.setUserCount(3);
        orderMapper.insertOrder(orderPojo);
    }
}