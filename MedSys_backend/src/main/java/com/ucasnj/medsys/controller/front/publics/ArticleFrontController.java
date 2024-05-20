package com.ucasnj.medsys.controller.front.publics;

import com.ucasnj.medsys.service.back.ArticleService;
import com.ucasnj.medsys.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/front/publics/article")
public class ArticleFrontController {
  @Autowired private ArticleService articleService;

  @GetMapping("/getArticleTop6")
  public Result getArticleTop6() {
    return articleService.getArticleTop6();
  }

  @GetMapping("/list")
  public Result list(
      Integer curPage,
      @RequestParam(defaultValue = "0") Integer tid,
      @RequestParam(defaultValue = "") String title,
      Integer pageSize) {
    String flag = "审核通过";
    return articleService.list(curPage, flag, tid, title, pageSize);
  }
}
