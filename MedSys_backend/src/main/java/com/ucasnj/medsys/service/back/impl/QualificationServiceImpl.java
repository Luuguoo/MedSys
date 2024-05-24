package com.ucasnj.medsys.service.back.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ucasnj.medsys.domain.Qualification;
import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.mapper.back.QualificationMapper;
import com.ucasnj.medsys.mapper.back.UsersMapper;
import com.ucasnj.medsys.service.back.QualificationService;
import com.ucasnj.medsys.util.Result;
import com.ucasnj.medsys.utils.ConstantUtils;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @作者：姚俊涛
 * @创建时间：19:43 2022/3/22
 */
@Service
public class QualificationServiceImpl implements QualificationService {

  @Autowired
  private QualificationMapper qualificationMapper;
  @Autowired
  private UsersMapper usersMapper;

  @Override
  public Result add(Qualification qualification) {
    boolean b = qualificationMapper.add(qualification);
    if (b) {
      return Result.builder().code(1).msg("申请提交成功，等待管理员审核").build();
    }else {
      return Result.builder().code(2).msg("申请提交失败").build();
    }
  }

  @Override
  public Result getByLname(String lname) {
    Integer isDel = 0;
    Qualification qualification = qualificationMapper.getByLname(lname,isDel);
    if (qualification == null) {
      return Result.builder().code(1).msg("查询成功").data(2).build();
    }else {
      return Result.builder().code(1).msg("查询成功").data(0).build();
    }
  }

  @Override
  public Result list(Integer curPage, Integer pageSize) {
    //待审核的列表
    Integer isDel = 0;
    PageHelper.startPage(curPage,pageSize);
    List<Qualification> list = qualificationMapper.list(isDel);
    for (Qualification qualification : list) {
      qualification.setPic(ConstantUtils.staticPath+qualification.getPic());
    }
    return Result.builder().code(1).msg("查询成功").data(new PageInfo<>(list)).build();
  }

  @Override
  public Result check(Integer id, Integer checkResult, HttpSession session) {
    qualificationMapper.updateStatusById(id,checkResult);
    if (checkResult==1){
     Qualification qualification = qualificationMapper.findById(id);
      usersMapper.updateLevelByLname(qualification.getLname());
    }
    return Result.builder().code(1).msg("审核成功").build();
  }
}
