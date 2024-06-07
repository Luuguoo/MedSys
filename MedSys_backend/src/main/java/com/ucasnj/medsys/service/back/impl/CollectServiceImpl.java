package com.ucasnj.medsys.service.back.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ucasnj.medsys.domain.Article;
import com.ucasnj.medsys.domain.Collect;
import com.ucasnj.medsys.mapper.back.ArticleMapper;
import com.ucasnj.medsys.mapper.back.CollectMapper;
import com.ucasnj.medsys.service.back.CollectService;
import com.ucasnj.medsys.utils.Result;
import com.ucasnj.medsys.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CollectServiceImpl implements CollectService {
  @Autowired private CollectMapper collectMapper;
  @Autowired private ArticleMapper articleMapper;

  @Override
  public Result list(Integer curPage, String lname, Integer pageSize) {
    PageHelper.startPage(curPage, pageSize);
    List<Collect> list = collectMapper.list(lname);
    for (Collect collect : list) {
      Integer aid = collect.getAid();
      Article article = articleMapper.findByAid(aid);
      article.setPhoto(ConstantUtils.staticPath + article.getPhoto());
      collect.setArticle(article);
    }
    return Result.builder().code(1).msg("查询成功").data(new PageInfo<>(list)).build();
  }

  @Override
  public Result del(String id) {
    collectMapper.del(id);
    return Result.builder().code(1).msg("删除成功").build();
  }

  @Override
  public Result add(Integer aid, String lname) {
    Collect c = collectMapper.findByAidAndLname(aid, lname);
    if (c != null) {
      return Result.builder().code(2).msg("请勿重复收藏").build();
    }
    Collect collect = new Collect();
    collect.setAid(aid);
    collect.setLname(lname);
    collect.setAddtime(new Date());
    collectMapper.add(collect);
    return Result.builder().code(1).msg("收藏成功").build();
  }
}
