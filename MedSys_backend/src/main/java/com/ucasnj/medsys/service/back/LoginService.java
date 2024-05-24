package com.ucasnj.medsys.service.back;

import com.ucasnj.medsys.domain.Admin;
import com.ucasnj.medsys.util.Result;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

  int login(Admin admin, HttpServletRequest request);

  Result updatePass(Integer aid, String pass);


  Admin findAdminByLname(String lname);
}
