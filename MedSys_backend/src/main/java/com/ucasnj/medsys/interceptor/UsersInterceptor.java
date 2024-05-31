package com.ucasnj.medsys.interceptor;

import com.ucasnj.medsys.domain.Admin;
import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.utils.ConstantUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UsersInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler) {
    try {
      Users users = (Users) request.getSession().getAttribute("users");
      if (users != null) {
        return true;
      }
      //没登录重定向到登录页面
      response.sendRedirect(ConstantUtils.frontLoginAddr);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
}
