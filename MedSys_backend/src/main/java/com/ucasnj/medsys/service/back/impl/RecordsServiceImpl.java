package com.ucasnj.medsys.service.back.impl;

import com.ucasnj.medsys.domain.Records;
import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.mapper.back.RecordsMapper;
import com.ucasnj.medsys.mapper.back.UsersMapper;
import com.ucasnj.medsys.service.back.RecordsService;
import com.ucasnj.medsys.utils.Result;
import com.ucasnj.medsys.utils.ConstantUtils;
import com.ucasnj.medsys.utils.OutExcle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class RecordsServiceImpl implements RecordsService {

  @Autowired
  private RecordsMapper recordsMapper;
  @Autowired
  private UsersMapper usersMapper;

  @Override
  public Result getTrending() {
    List<Records> list = recordsMapper.getTrending();
    return Result.builder().code(1).data(list).msg("查询成功").build();
  }

  @Override
  public Result add(String name) {
    recordsMapper.add(name);
    return Result.builder().build();
  }

  @Override
  public void download(HttpServletRequest request, HttpServletResponse response) {
    List<Records> list = recordsMapper.getTrending();
    Users users = (Users) request.getSession().getAttribute("users");
    if (users.getLevel()!=1) {
      log.error("{}，该用户没有访问权限",users.getLname());
      return;
    }
    String path = ConstantUtils.excelPath;
    String filePath = OutExcle.createExcel(list, path);
    OutExcle.download(request, response, filePath);
    OutExcle.deleteFile(filePath);
  }
}
