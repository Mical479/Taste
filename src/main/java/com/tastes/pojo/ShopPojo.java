package com.tastes.pojo;

import lombok.Data;

@Data
public class ShopPojo {
    private String shopId;

    private String shopName;

    private Double score;

    private String address;

    private String openTime;

    private String headIcon;

    private int avgPrice;
}
