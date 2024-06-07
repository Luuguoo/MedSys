package com.ucasnj.medsys.service.back.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ucasnj.medsys.domain.Article;
import com.ucasnj.medsys.domain.Atype;
import com.ucasnj.medsys.mapper.back.ArticleMapper;
import com.ucasnj.medsys.mapper.back.AtypeMapper;
import com.ucasnj.medsys.mapper.back.UsersMapper;
import com.ucasnj.medsys.service.back.ArticleService;
import com.ucasnj.medsys.utils.Result;
import com.ucasnj.medsys.utils.ConstantUtils;
import java.util.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  private ArticleMapper articleMapper;
  @Autowired
  private AtypeMapper atypeMapper;
  @Autowired
  private UsersMapper usersMapper;

  @Override
  public Result list(
      Integer curPage, String flag, Integer tid, String title, String lname, Integer pageSize) {
    PageHelper.startPage(curPage, pageSize);
    List<Article> list = articleMapper.list(flag, tid, title, lname);
    for (Article article : list) {
      article.setPhoto(ConstantUtils.staticPath + article.getPhoto());
      Atype atype = atypeMapper.findByTid(article.getTid());
      article.setAtype(atype);
    }
    return Result.builder().code(1).msg("查询成功").data(new PageInfo(list)).build();
  }

  @Override
  public Result del(String aid) {
    try {
      articleMapper.del(aid);
      return Result.builder().code(1).msg("删除成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("删除失败").build();
    }
  }

  @Override
  public Result add(Article article) {
    try {
      articleMapper.add(article);
      return Result.builder().code(1).msg("添加成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("添加失败").build();
    }
  }

  @Override
  public Result update(Article article) {
    try {
      articleMapper.update(article);
      return Result.builder().code(1).msg("修改成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("修改失败").build();
    }
  }

  @Override
  public Result updateFlagByAid(Integer aid, String checkResult) {
    try {
      articleMapper.updateFlagByAid(aid, checkResult);
      return Result.builder().code(1).msg("操作成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("操作失败,请重试").build();
    }
  }

  @Override
  public Result getArticleTop6() {
    List<Article> list = articleMapper.getArticleTop6();
    for (Article article : list) {
      article.setPhoto(ConstantUtils.staticPath + article.getPhoto());
    }
    return Result.builder().code(1).msg("查询成功").data(list).build();
  }

  @Override
  public Result list(Integer curPage, String flag, Integer tid, String title, Integer pageSize) {
    PageHelper.startPage(curPage, pageSize);
    List<Article> list = articleMapper.findAll(flag, tid, title);
    for (Article article : list) {
      article.setPhoto(ConstantUtils.staticPath + article.getPhoto());
      Integer level = usersMapper.findUsersLevelByLname(article.getLname());
      article.setUsersLevel(level);
    }
    return Result.builder().code(1).msg("查询成功").data(new PageInfo(list)).build();
  }

  @Override
  public Result list(Integer curPage, String lname, Integer pageSize) {
    PageHelper.startPage(curPage, pageSize);
    List<Article> list = articleMapper.getAllByLname(lname);
    for (Article article : list) {
      article.setPhoto(ConstantUtils.staticPath + article.getPhoto());
    }
    return Result.builder().code(1).msg("查询成功").data(new PageInfo(list)).build();
  }

  @Override
  public Result findByAid(Integer aid) {
    Article article = articleMapper.findByAid(aid);
    article.setPhoto(ConstantUtils.staticPath + article.getPhoto());
    return Result.builder().code(1).msg("查询成功").data(article).build();
  }
}
