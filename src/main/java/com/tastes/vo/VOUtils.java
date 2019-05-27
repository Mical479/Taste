package com.tastes.vo;

public class VOUtils {

    public static FrontTemplate success(Object object){
        FrontTemplate frontTemplate = new FrontTemplate();
        frontTemplate.setData(object);
        frontTemplate.setCode(0);
        frontTemplate.setMsg("成功");
        return frontTemplate;
    }

    public static FrontTemplate success(){
        return success(null);
    }

    public static FrontTemplate error(Integer code, String msg){
        FrontTemplate frontTemplate = new FrontTemplate();
        frontTemplate.setCode(code);
        frontTemplate.setMsg(msg);
        return frontTemplate;
    }
}
