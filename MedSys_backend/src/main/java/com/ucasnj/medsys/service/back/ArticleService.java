package com.ucasnj.medsys.service.back;
import com.ucasnj.medsys.domain.Article;
import com.ucasnj.medsys.utils.Result;

public interface ArticleService {
    Result list(Integer curPage,String flag, Integer tid, String title, String lname, Integer pageSize);

    Result del(String aid);

    Result add(Article article);

    Result update(Article article);

    Result updateFlagByAid(Integer aid, String checkResult);

    Result getArticleTop6();

    Result list(Integer curPage, String flag, Integer tid, String title, Integer pageSize);


    Result list(Integer curPage, String lname, Integer pageSize);

    Result findByAid(Integer aid);
}
