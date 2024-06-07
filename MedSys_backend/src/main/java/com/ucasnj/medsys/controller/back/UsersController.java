package com.ucasnj.medsys.controller.back;

import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.service.back.UsersService;
import com.ucasnj.medsys.utils.Result;
import com.ucasnj.medsys.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/back/users")
//用户管理
public class UsersController {

  @Autowired
  private UsersService usersService;

  @GetMapping("/list")
  public Result list(Integer curPage, String lname, String username, Integer pageSize) {
    return usersService.list(curPage, lname, username, pageSize);
  }

  @GetMapping("/del")
  public Result del(String lname) {
    return usersService.del(lname);
  }

  @PostMapping("/Update")
  public Result update(Users users, MultipartFile touxiang) {
    Users users1 = usersService.findUsersByTel(users.getTel());
    if (users1 != null) {
      if (!users1.getLname().equals(users.getLname())) {
        return Result.builder().code(2).msg("手机号已存在").build();
      }
    }
    if (touxiang != null) {
      File path = new File(ConstantUtils.imagePath + "upload/");
      if (!path.exists()) {
        path.mkdirs();
      }
      String filename = touxiang.getOriginalFilename();
      String exName = filename.substring(filename.lastIndexOf("."));
      filename = UUID.randomUUID().toString().replaceAll("-", "") + exName;

      File file = new File(path, filename);
      try {
        touxiang.transferTo(file);
        users.setPic("/upload/" + filename);
      } catch (IOException e) {
        e.printStackTrace();
        return Result.builder().code(2).msg("修改失败").build();
      }
    } else {
      users.setPic(users.getPic().substring(users.getPic().lastIndexOf("/upload")));
    }
    return usersService.update(users);
  }

  @PostMapping("/add")
  public Result add(Users users, MultipartFile touxiang) {
    if (usersService.findUsersByLname(users.getLname()) != null) {
      return Result.builder().code(2).msg("用户名已存在").build();
    }
    if (usersService.findUsersByTel(users.getTel()) != null) {
      return Result.builder().code(2).msg("手机号已存在").build();
    }
    File path = new File(ConstantUtils.imagePath + "upload/");
    if (!path.exists()) {
      path.mkdirs();
    }
    String filename = touxiang.getOriginalFilename();
    String exName = filename.substring(filename.lastIndexOf("."));
    filename = UUID.randomUUID().toString().replaceAll("-", "") + exName;

    File file = new File(path, filename);
    try {
      touxiang.transferTo(file);
      users.setPic("/upload/" + filename);
      users.setRegdate(new Date());
      return usersService.add(users);
    } catch (IOException e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("添加失败").build();
    }
  }
}
