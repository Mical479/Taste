package com.tastes.enums;

import lombok.Getter;

@Getter
public enum LoginEnum {
    FAILED(4,"短信验证失败"),
    PINGFAN(1,"短信发送频繁"),
    STYLEERROR(2, "手机号码格式不正确"),
    VERTIFICATION(3, "验证码不正确")
    ;

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    LoginEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
