package com.tastes.controller;

import com.tastes.mapper.UserMapper;
import com.tastes.pojo.UserInfoPojo;
import com.tastes.service.SmsService;
import com.tastes.vo.FrontTemplate;
import com.tastes.vo.VOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    @Autowired
    private SmsService smsService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("shop/login/vertification")
    public FrontTemplate getCode(@RequestParam("phone") String phone){
        smsService.sendSmsCode(phone);
        return VOUtils.success();
    }

    @RequestMapping("shop/login")
    public FrontTemplate Login(@RequestParam("phone") String phone,
                               @RequestParam("code") String code){
        if (smsService.validSmsCode(phone, code)){
            UserInfoPojo userInfoPojo1 = userMapper.GetUserByTel(phone);
            if (userInfoPojo1 != null) {
                System.out.println(userInfoPojo1);
                return VOUtils.success(userInfoPojo1);
            } else {
                UserInfoPojo userInfoPojo = new UserInfoPojo();
                userInfoPojo.setTel(phone);
                userInfoPojo.setNickname(phone);
                userMapper.InsertUser(userInfoPojo);
                System.out.println(userInfoPojo);
                return VOUtils.success(userMapper.GetUserByTel(phone));
            }
        }
       return VOUtils.error(1,"验证码错误");
    }

    @RequestMapping("shop/login/weixin")
    public FrontTemplate WeixinLogin(@RequestParam("nickname") String nickname,
                            @RequestParam("openid") String openid,
                            @RequestParam("headimg") String headimg){
        if(userMapper.GetUserByOpenId(openid) == null){
            UserInfoPojo userInfoPojo = new UserInfoPojo();
            userInfoPojo.setNickname(nickname);
            userInfoPojo.setOpenid(openid);
            userInfoPojo.setHeadimg(headimg);
            userMapper.InsertUser(userInfoPojo);

            return VOUtils.success();
        }
        return VOUtils.success();
    }
}
