package com.ucasnj.medsys.controller.back;

import com.ucasnj.medsys.domain.Admin;
import com.ucasnj.medsys.service.back.LoginService;
import com.ucasnj.medsys.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
@RequestMapping("/back")
//后台登录
public class LoginController {
  @Autowired private LoginService loginService;

  @PostMapping("/login")
  public int login(Admin admin, HttpServletRequest request) {
    return loginService.login(admin, request);
  }
  @GetMapping("/logout")
  public Result logout(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.removeAttribute("admin");
    return Result.builder().code(1).build();
  }

  @PostMapping("/updatePass")
  public Result updatePass(String yuanPass,String pass,HttpServletRequest request){
    HttpSession session = request.getSession();
    Admin admin = (Admin)session.getAttribute("admin");
    String pwd = admin.getPwd();
    if (pwd.equals(yuanPass)){
      Result result = loginService.updatePass(admin.getAid(), pass);
      session.setAttribute("admin",loginService.findAdminByLname(admin.getLname()));
      return result;
    }else {
      return Result.builder().code(2).msg("原密码不正确").build();
    }
  }

}
