package com.tastes.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Sms implements Serializable {
    private String phone;

    private String code;

    private Long time;

    public Sms(String phone) {
        this.phone = phone;
    }

    public Sms(String phone, String code, Long time) {
        this.phone = phone;
        this.code = code;
        this.time = time;
    }
}
