package com.ucasnj.medsys.controller.front.publics;

import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.service.back.UsersService;
import com.ucasnj.medsys.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
@RequestMapping("/front/publics/users")
public class UsersFrontController {
  @Autowired private UsersService usersService;

  @PostMapping("/login")
  public Result login(String lname, String password, HttpServletRequest request) {
    return usersService.login(lname, password, request);
  }
}
