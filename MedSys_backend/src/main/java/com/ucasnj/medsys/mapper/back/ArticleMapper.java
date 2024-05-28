package com.ucasnj.medsys.mapper.back;

import com.ucasnj.medsys.domain.Article;
import com.ucasnj.medsys.domain.Atype;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleMapper {

  List<Article> list(String flag, Integer tid, String title, String lname);

  void del(String aid);

  void add(Article article);

  void update(Article article);

  void updateFlagByAid(Integer aid, String checkResult);

  Article findByAid(Integer aid);

  List<Article> findByTid(Integer tid);

  List<Article> getArticleTop6();

  List<Article> findAll(String flag, Integer tid, String title);


  List<Article> getAllByLname(String lname);

  void updateAmemoByAid(Integer aid, String xmemo);
}
