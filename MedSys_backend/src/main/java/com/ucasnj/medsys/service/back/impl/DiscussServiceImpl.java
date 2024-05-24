package com.ucasnj.medsys.service.back.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ucasnj.medsys.domain.Discuss;
import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.mapper.back.DiscussMapper;
import com.ucasnj.medsys.mapper.back.UsersMapper;
import com.ucasnj.medsys.service.back.DiscussService;
import com.ucasnj.medsys.util.Result;
import com.ucasnj.medsys.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DiscussServiceImpl implements DiscussService {
  @Autowired private DiscussMapper discussMapper;

  @Autowired private UsersMapper usersMapper;

  @Override
  public Result list(Integer curPage, String name, Integer pageSize) {
    PageHelper.startPage(curPage, pageSize);
    List<Discuss> list = discussMapper.list(name);
    return Result.builder().code(1).msg("查询成功").data(new PageInfo(list)).build();
  }

  @Override
  public Result list(Integer curPage, Integer aid, Integer pageSize) {
    PageHelper.startPage(curPage, pageSize);
    List<Discuss> list = discussMapper.findByAid(aid);
    for (Discuss discuss : list) {
      String lname = discuss.getLname();
      Users user = usersMapper.findUsersByLname(lname);
      user.setPic(ConstantUtils.staticPath + user.getPic());
      discuss.setUsers(user);
    }
    return Result.builder().code(1).msg("查询成功").data(new PageInfo(list)).build();
  }

  @Override
  public Result del(Integer id) {
    try {
      discussMapper.del(id);
      return Result.builder().code(1).msg("删除成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("删除失败").build();
    }
  }

  @Override
  public Result list(Integer curPage, Integer pageSize, String lname) {
    PageHelper.startPage(curPage, pageSize);
    List<Discuss> list = discussMapper.findAllByLname(lname);
    return Result.builder().code(1).msg("查询成功").data(new PageInfo(list)).build();
  }

  @Override
  public Result add(Discuss discuss) {
    try{
      discussMapper.add(discuss);
      return Result.builder().code(1).msg("发表成功").build();
    }catch (Exception e){
      e.printStackTrace();
      return Result.builder().code(2).msg("发表失败").build();

    }
  }
}
