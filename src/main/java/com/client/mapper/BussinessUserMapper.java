package com.client.mapper;

import com.client.pojo.BussinessUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 类 名 称：BussinessUserMapper
 * 类 描 述：TODO
 * 创建时间：2019/5/25 16:31
 * 创建人：Mical
 */
@Mapper
public interface BussinessUserMapper {

    @Select("select * from bussiness_user where nick_name=#{nickName}")
    public BussinessUser selectByNickName(String nickName);
}
