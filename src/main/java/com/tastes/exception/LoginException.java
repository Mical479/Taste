package com.tastes.exception;

import com.tastes.enums.LoginEnum;
import lombok.Data;

@Data
public class LoginException extends RuntimeException {

    private Integer code;

    public LoginException(LoginEnum loginEnum){
        super(loginEnum.getMsg());
        this.code = loginEnum.getCode();
    }

    public LoginException(Integer code, String msg){
        super(msg);
        this.code = code;
    }
}
