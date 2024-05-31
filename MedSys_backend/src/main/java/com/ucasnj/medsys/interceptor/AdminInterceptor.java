package com.ucasnj.medsys.interceptor;

import com.ucasnj.medsys.domain.Admin;
import com.ucasnj.medsys.utils.ConstantUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class AdminInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler) {
    try {
      Admin admin = (Admin) request.getSession().getAttribute("admin");
      if (admin != null) {
        return true;
      }
      //没登录重定向到登录页面
      response.sendRedirect(ConstantUtils.backLoginAddr);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
}
