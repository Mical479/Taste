package com.tastes.mapper;

import com.tastes.pojo.UserInfoPojo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    @Insert("insert into user_info(nickname, tel, pasword, openid, headimg) values (#{nickname}, #{tel}, #{pasword}, #{openid}, #{headimg})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int InsertUser(UserInfoPojo userInfoPojo);

    @Select("select * from user_info where openid=#{openid}")
    public UserInfoPojo GetUserByOpenId(String openid);

    @Select("select * from user_info where tel=#{tel}")
    public UserInfoPojo GetUserByTel(String tel);
}
