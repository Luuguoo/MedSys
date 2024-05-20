package com.ucasnj.medsys.controller.front.protects;

import com.ucasnj.medsys.controller.back.UsersController;
import com.ucasnj.medsys.domain.Admin;
import com.ucasnj.medsys.domain.Qualification;
import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.service.back.QualificationService;
import com.ucasnj.medsys.service.back.RecordsService;
import com.ucasnj.medsys.service.back.UsersService;
import com.ucasnj.medsys.util.Result;
import com.ucasnj.medsys.utils.ConstantUtils;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
@RequestMapping("/front/protects/users")
public class UsersFrontProtectController {

  @Autowired
  private UsersService usersService;
  @Autowired
  private UsersController usersController;
  @Autowired
  private QualificationService qualificationService;
  @Autowired
  private RecordsService recordsService;

  @GetMapping("/getInfo")
  public Result getInfo(String lname, HttpServletRequest request) {
    HttpSession session = request.getSession();
    Users users = (Users) session.getAttribute("users");
    if (users == null) {
      return Result.builder().code(2).msg("登录失效,请重新登录").build();
    } else {
      return Result.builder().code(1).msg("获取用户信息成功").data(users).build();
    }
  }

  @GetMapping("/logout")
  public Result logout(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.removeAttribute("users");
    return Result.builder().code(1).build();
  }

  @PostMapping("/Update")
  public Result update(Users users, MultipartFile touxiang, HttpServletRequest request) {
    Result result = usersController.update(users, touxiang);
    if (result.getCode() == 1) {
      Users temp = usersService.findUsersByTel(users.getTel());
      temp.setPic(ConstantUtils.staticPath + temp.getPic());
      request.getSession().setAttribute("users", temp);
    }
    return result;
  }

  @PostMapping("/updatePass")
  public Result updatePass(String yuanPass, String pass, HttpServletRequest request) {
    HttpSession session = request.getSession();
    Users users = (Users) session.getAttribute("users");
    String password = users.getPassword();
    if (password.equals(yuanPass)) {
      Result result = usersService.updatePass(users.getLname(), pass);
      if (result.getCode() == 1) {
        Users temp = usersService.findUsersByTel(users.getTel());
        temp.setPic(ConstantUtils.staticPath + temp.getPic());
        request.getSession().setAttribute("users", temp);
      }
      return result;
    } else {
      return Result.builder().code(2).msg("原密码不正确").build();
    }
  }

  @PostMapping("/upLevel")
  public Result upLevel(MultipartFile ziGeZheng, HttpServletRequest request) {
    Users users = (Users) request.getSession().getAttribute("users");
    if (users == null) {
      return Result.builder().code(2).msg("登陆失效，请重新登陆").build();
    }
    Qualification qualification = new Qualification();
    File path = new File(ConstantUtils.imagePath + "upload/");
    if (!path.exists()) {
      path.mkdirs();
    }
    String filename = ziGeZheng.getOriginalFilename();
    String exName = filename.substring(filename.lastIndexOf("."));
    filename = UUID.randomUUID().toString().replaceAll("-", "") + exName;

    File file = new File(path, filename);
    try {
      ziGeZheng.transferTo(file);
      qualification.setPic("/upload/" + filename);
      qualification.setLname(users.getLname());
      qualification.setStatus(0);
      qualification.setIsDel(0);
      return qualificationService.add(qualification);
    } catch (IOException e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("添加失败").build();
    }
  }

  @GetMapping("/download")
  public void download(HttpServletRequest request, HttpServletResponse response) {
    recordsService.download(request, response);
  }
}
