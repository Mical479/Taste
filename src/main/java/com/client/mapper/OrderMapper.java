package com.client.mapper;

import com.client.pojo.OrderPojo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 类 名 称：OrderMapper
 * 类 描 述：TODO
 * 创建时间：2019/5/25 23:02
 * 创建人：Mical
 */
@Mapper
public interface OrderMapper {

    @Insert("insert into order_info(shop_id,row_numbers,order_id,user_id,order_status,user_count,order_time,meal_time,remark) values (#{shopId},#{rowNumbers},#{orderId},#{userId},#{orderStatus},#{userCount},#{orderTime},#{mealTime},#{remark})")
    public void insertOrder(OrderPojo orderPojo);

    @Select("select count(*) from order_info")
    public Integer selectRowNumber();
}
