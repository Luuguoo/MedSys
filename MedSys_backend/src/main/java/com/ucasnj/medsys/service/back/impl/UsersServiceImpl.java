package com.ucasnj.medsys.service.back.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ucasnj.medsys.domain.Admin;
import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.mapper.back.UsersMapper;
import com.ucasnj.medsys.service.back.UsersService;
import com.ucasnj.medsys.util.Result;
import com.ucasnj.medsys.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
  @Autowired private UsersMapper usersMapper;

  @Override
  public Result list(Integer curPage, String lname, String username, Integer pageSize) {
    PageHelper.startPage(curPage, pageSize);
    List<Users> list = usersMapper.list(lname, username);
    for (Users users : list) {
      users.setPic(ConstantUtils.staticPath + users.getPic());
    }

    return Result.builder().code(1).msg("查询成功").data(new PageInfo(list)).build();
  }

  @Override
  public Result del(String lname) {
    try {
      usersMapper.del(lname);
      return Result.builder().code(1).msg("删除成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("删除失败").build();
    }
  }

  @Override
  public Result add(Users users) {
    try {
      usersMapper.add(users);
      return Result.builder().code(1).msg("添加成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("添加失败").build();
    }
  }

  @Override
  public Users findUsersByTel(String tel) {
    return usersMapper.findUsersByTel(tel);
  }

  @Override
  public Result update(Users users) {
    try {
      usersMapper.update(users);
      return Result.builder().code(1).msg("修改成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("修改失败").build();
    }
  }

    @Override
    public Result login(String lname, String password, HttpServletRequest request) {
      Users users = usersMapper.findUsersAllByLname(lname);
      if (users == null) {
        return Result.builder().code(2).msg("用户不存在").build();
      }
      if (users.getPassword().equals(password)) {
        users.setPic(ConstantUtils.staticPath+users.getPic());
        HttpSession session = request.getSession();
        session.setAttribute("users", users);
        return Result.builder().code(1).msg("登录成功").build();
      } else {
        return Result.builder().code(3).msg("密码不正确").build();
      }
    }

  @Override
  public Result updatePass(String lname, String pass) {
    try{
      usersMapper.updatePass(lname,pass);
      return Result.builder().code(1).msg("密码修改成功").build();
    }catch (Exception e){
      e.printStackTrace();
      return Result.builder().code(2).msg("密码修改失败").build();

    }
  }

  @Override
  public Users findUsersByLname(String lname) {
    return usersMapper.findUsersAllByLname(lname);
  }
}
