package com.client.interceptors;

import com.client.pojo.BussinessUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 类 名 称：LoginInterceptor
 * 类 描 述：登录验证的拦截器
 * 创建时间：2019/5/25 17:04
 * 创建人：Mical
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        BussinessUser user = (BussinessUser) request.getSession().getAttribute("user");
        if (user == null){
            response.sendRedirect("/login");
            return false;
        }else {
            return true;
        }
    }
}
