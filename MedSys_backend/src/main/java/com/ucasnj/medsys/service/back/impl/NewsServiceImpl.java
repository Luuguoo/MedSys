package com.ucasnj.medsys.service.back.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ucasnj.medsys.domain.News;
import com.ucasnj.medsys.mapper.back.NewsMapper;
import com.ucasnj.medsys.service.back.NewsService;
import com.ucasnj.medsys.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
  @Autowired private NewsMapper newsMapper;

  @Override
  public Result list(Integer curPage, String name, Integer pageSize) {
    PageHelper.startPage(curPage, pageSize);
    List<News> list = newsMapper.list(name);
    return Result.builder().code(1).msg("查询成功").data(new PageInfo(list)).build();
  }

  @Override
  public Result del(Integer id) {
    try {
      newsMapper.del(id);
      return Result.builder().code(1).msg("删除成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("删除失败").build();
    }
  }

  @Override
  public Result add(News news) {
    try {
      newsMapper.add(news);
      return Result.builder().code(1).msg("添加成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("添加失败").build();
    }
  }

  @Override
  public Result update(News news) {
    try {
      newsMapper.update(news);
      return Result.builder().code(1).msg("修改成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("修改失败").build();
    }
  }
}
