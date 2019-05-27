package com.tastes.mapper;

import com.github.pagehelper.Page;
import com.tastes.pojo.ShopInfoPojo;
import com.tastes.pojo.ShopJingPojo;
import com.tastes.pojo.ShopKeyword;
import com.tastes.pojo.ShopPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ShopMapper {

    @Select("select shop_id,shop_name,score,address,open_time,head_icon,phone,avg_price from shop_info where shop_id=#{id}")
    public ShopInfoPojo SelectOne(int id);

    @Select("select shop_id,shop_name,score,address,open_time,head_icon,avg_price from shop_info")
    public Page<ShopPojo> SelectAll();

    @Select("select shop_id,shop_name,head_icon from shop_info where shop_name like '%" + "${keyword}" + "%'")
    public List<ShopJingPojo> SellectShops(ShopKeyword keyword);

    @Select("select shop_id,shop_name,head_icon,avg_price,score from shop_info where score=5 and avg_price != 0")
    public List<ShopJingPojo> TopShops();

    @Select("select shop_id,shop_name,head_icon,avg_price,score from shop_info where score=5 and avg_price != 0 limit #{count}")
    public List<ShopJingPojo> TopShopsCount(int count);

    @Select("select shop_id,shop_name,head_icon,avg_price,score from shop_info where score = 5 and wifi != 0 and park != '' and avg_price > 45 limit 6")
    public List<ShopJingPojo> TuijianShops();
}
