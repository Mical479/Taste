package com.tastes.handler;

import com.tastes.exception.LoginException;
import com.tastes.vo.FrontTemplate;
import com.tastes.vo.VOUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class LoginExceptionHandler {

    @ExceptionHandler(value = LoginException.class)
    @ResponseBody
    public FrontTemplate handlerLoginException(LoginException e){
        return VOUtils.error(e.getCode(), e.getMessage());
    }
}
