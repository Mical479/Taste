package com.client.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 类 名 称：OrderPojo
 * 类 描 述：订单实体类
 * 创建时间：2019/5/25 22:50
 * 创建人：Mical
 */
@Data
public class OrderPojo implements Serializable {
    private Integer shopId;
    private Integer rowNumbers;
    private Integer userId;
    private Integer orderStatus;
    private Integer userCount;
    private Date orderTime;
    private Date mealTime;
    private String remark;
    private String orderId;
}
