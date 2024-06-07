package com.ucasnj.medsys.service.back.impl;

import com.ucasnj.medsys.domain.Admin;
import com.ucasnj.medsys.mapper.back.LoginMapper;
import com.ucasnj.medsys.service.back.LoginService;
import com.ucasnj.medsys.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
  @Autowired private LoginMapper loginMapper;

  @Override
  public int login(Admin admin, HttpServletRequest request) {
    String lname = admin.getLname();
    Admin realAdmin = loginMapper.getAdminByUsername(lname);
    if (realAdmin == null) {
      return 2;
    }
    if (realAdmin.getPwd().equals(admin.getPwd())) {
      HttpSession session = request.getSession();
      session.setAttribute("admin", realAdmin);
      return 1;
    } else {
      return 3;
    }
  }

  @Override
  public Result updatePass(Integer aid, String pass) {
    loginMapper.updatePass(aid,pass);
    return Result.builder().code(1).msg("密码修改成功").build();
  }

  @Override
  public Admin findAdminByLname(String lname) {
    return loginMapper.getAdminByUsername(lname);
  }

}
