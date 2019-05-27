package com.client.mapper;

import com.client.pojo.BussinessUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 类 名 称：BussinessUserMapperTest
 * 类 描 述：TODO
 * 创建时间：2019/5/25 16:34
 * 创建人：Mical
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BussinessUserMapperTest {

    @Autowired
    private BussinessUserMapper bussinessUserMapper;

    @Test
    public void test(){
        BussinessUser mical = bussinessUserMapper.selectByNickName("mical");
        System.out.println(mical);
    }
}