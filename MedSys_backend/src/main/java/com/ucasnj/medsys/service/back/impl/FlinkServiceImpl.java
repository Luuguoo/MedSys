package com.ucasnj.medsys.service.back.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ucasnj.medsys.domain.Flink;
import com.ucasnj.medsys.domain.News;
import com.ucasnj.medsys.mapper.back.FlinkMapper;
import com.ucasnj.medsys.service.back.FlinkService;
import com.ucasnj.medsys.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FlinkServiceImpl implements FlinkService {
  @Autowired private FlinkMapper flinkMapper;
  
  @Override
  public Result list(Integer curPage,  Integer pageSize) {
    PageHelper.startPage(curPage, pageSize);
    List<Flink> list = flinkMapper.list();
    return Result.builder().code(1).msg("查询成功").data(new PageInfo(list)).build();
  }

  @Override
  public Result del(Integer id) {
    try {
      flinkMapper.del(id);
      return Result.builder().code(1).msg("删除成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("删除失败").build();
    }
  }

  @Override
  public Result add(Flink flink) {
    try {
      flinkMapper.add(flink);
      return Result.builder().code(1).msg("添加成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("添加失败").build();
    }
  }

  @Override
  public Result update(Flink flink) {
    try {
      flinkMapper.update(flink);
      return Result.builder().code(1).msg("修改成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("修改失败").build();
    }
  }

    @Override
    public Result findAll() {
      List<Flink> list = flinkMapper.list();
      return Result.builder().code(1).msg("查询成功").data(list).build();
    }
}
