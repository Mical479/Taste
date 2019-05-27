package com.tastes.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tastes.mapper.ShopMapper;
import com.tastes.pojo.ShopInfoPojo;
import com.tastes.pojo.ShopJingPojo;
import com.tastes.pojo.ShopKeyword;
import com.tastes.pojo.ShopPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ShopMapper shopMapper;

    @RequestMapping("/shop/{id}")
    public ShopInfoPojo SelectShopOne(@PathVariable("id") int id){
        ShopInfoPojo shopInfoPojo = shopMapper.SelectOne(id);
        String phone = shopInfoPojo.getPhone();
        phone = phone.split("/")[0];
        shopInfoPojo.setPhone(phone);
        return shopInfoPojo;
    }

    @RequestMapping("/shop")
    public Page<ShopPojo> SelectAllShop(@RequestParam("page") int page,
                                        @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(page, pagesize);
        Page<ShopPojo> list = shopMapper.SelectAll();
        return list;
    }

    @RequestMapping("/shop/search")
    public List<ShopJingPojo> SellectShops(@RequestParam("keyword") String keyword){
        if(keyword.equals(' ') || keyword == null){
            return null;
        }
        ShopKeyword shopKeyword = new ShopKeyword();
        shopKeyword.setKeyword(keyword);
        List<ShopJingPojo> shopJingPojos = shopMapper.SellectShops(shopKeyword);
        return shopJingPojos;
    }

    @RequestMapping("/shop/top")
    public List<ShopJingPojo> ShopTop(){
        return shopMapper.TopShops();
    }

    @RequestMapping("/shop/top/{count}")
    public List<ShopJingPojo> ShopTopCount(@PathVariable("count") int count){
        return shopMapper.TopShopsCount(count);
    }

    @RequestMapping("shop/tuijian")
    public List<ShopJingPojo> TuijianShops(){
        return shopMapper.TuijianShops();
    }
}
