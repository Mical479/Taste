package com.client.pojo;

import lombok.Data;

/**
 * 类 名 称：BussinessUser
 * 类 描 述：TODO
 * 创建时间：2019/5/25 16:29
 * 创建人：Mical
 */
@Data
public class BussinessUser {

    private Integer id;
    private String nickName;
    private String name;
    private String idNumber;
    private Integer shopId;
    private String password;
    private String tel;
    private String headUrl;
}
