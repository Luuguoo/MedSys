package com.ucasnj.medsys.service.back.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ucasnj.medsys.domain.Article;
import com.ucasnj.medsys.domain.Atype;
import com.ucasnj.medsys.domain.News;
import com.ucasnj.medsys.mapper.back.ArticleMapper;
import com.ucasnj.medsys.mapper.back.AtypeMapper;
import com.ucasnj.medsys.mapper.back.UsersMapper;
import com.ucasnj.medsys.service.back.AtypeService;
import com.ucasnj.medsys.util.Result;
import com.ucasnj.medsys.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AtypeServiceImpl implements AtypeService {

  @Autowired
  private AtypeMapper atypeMapper;
  @Autowired
  private ArticleMapper articleMapper;
  @Autowired
  private UsersMapper usersMapper;

  @Override
  public Result list(Integer curPage, Integer pageSize) {
    PageHelper.startPage(curPage, pageSize);
    List<Atype> list = atypeMapper.list();
    return Result.builder().code(1).msg("查询成功").data(new PageInfo(list)).build();
  }

  @Override
  public Result del(Integer tid) {
    try {
      atypeMapper.del(tid);
      return Result.builder().code(1).msg("删除成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("删除失败").build();
    }
  }

  @Override
  public Result add(Atype atype) {
    try {
      atypeMapper.add(atype);
      return Result.builder().code(1).msg("添加成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("添加失败").build();
    }
  }

  @Override
  public Result update(Atype atype) {
    try {
      atypeMapper.update(atype);
      return Result.builder().code(1).msg("修改成功").build();
    } catch (Exception e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("修改失败").build();
    }
  }

  @Override
  public Result findAll() {
    List<Atype> list = atypeMapper.list();
    return Result.builder().code(1).msg("查询成功").data(list).build();
  }

  @Override
  public Result findAllAndArticle() {
    List<Atype> list = atypeMapper.list();
    for (Atype atype : list) {
      List<Article> list1 = articleMapper.findByTid(atype.getTid());
      for (Article article : list1) {
        article.setPhoto(ConstantUtils.staticPath + article.getPhoto());
        Integer level = usersMapper.findUsersLevelByLname(article.getLname());
        article.setUsersLevel(level);
      }
      atype.setArticles(list1);
    }
    return Result.builder().code(1).msg("查询成功").data(list).build();
  }
}
