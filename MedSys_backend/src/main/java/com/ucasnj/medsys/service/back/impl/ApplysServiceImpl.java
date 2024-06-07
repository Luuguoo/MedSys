package com.ucasnj.medsys.service.back.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ucasnj.medsys.domain.Applys;
import com.ucasnj.medsys.domain.Article;
import com.ucasnj.medsys.mapper.back.ApplysMapper;
import com.ucasnj.medsys.mapper.back.ArticleMapper;
import com.ucasnj.medsys.service.back.ApplysService;
import com.ucasnj.medsys.utils.Result;
import com.ucasnj.medsys.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ApplysServiceImpl implements ApplysService {
  @Autowired private ApplysMapper applysMapper;
  @Autowired private ArticleMapper articleMapper;

  @Override
  public Result list(Integer curPage, String name, String flag, Integer pageSize) {
    PageHelper.startPage(curPage, pageSize);
    List<Applys> list = applysMapper.list(name, flag);
    for (Applys applys : list) {
      Article article = articleMapper.findByAid(applys.getAid());
      article.setPhoto(ConstantUtils.staticPath + article.getPhoto());
      applys.setArticle(article);
    }
    return Result.builder().code(1).msg("查询成功").data(new PageInfo(list)).build();
  }

  @Override
  public Result del(String id) {
    try {
      applysMapper.del(id);
      return Result.builder().code(1).msg("删除成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("删除失败").build();
    }
  }

  @Override
  public Result updateFlagById(Integer id, String checkResult) {
    try {
      if ("审核通过".equals(checkResult)) {
        Applys applys = applysMapper.findById(id);
        articleMapper.updateAmemoByAid(applys.getAid(), applys.getXmemo());
      }
      applysMapper.updateFlagById(id, checkResult);
      return Result.builder().code(1).msg("操作成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("操作失败,请重试").build();
    }
  }

  @Override
  public Result list(Integer curPage, String lname, Integer pageSize) {
    PageHelper.startPage(curPage,pageSize);
    List<Applys> list = applysMapper.listByLname(lname);
    for (Applys applys : list) {
      Article article = articleMapper.findByAid(applys.getAid());
      article.setPhoto(ConstantUtils.staticPath + article.getPhoto());
      applys.setArticle(article);
    }
    return Result.builder().code(1).msg("查询成功").data(new PageInfo<>(list)).build();
  }

    @Override
    public Result add(Applys applys) {
        applysMapper.add(applys);
        return Result.builder().code(1).msg("添加成功").build();
    }
}
