package com.ucasnj.medsys.controller.front.protects;

import com.ucasnj.medsys.controller.back.ArticleController;
import com.ucasnj.medsys.domain.Article;
import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.service.back.ArticleService;
import com.ucasnj.medsys.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/front/protects/article")
public class ArticleFrontProtectController {
  @Autowired private ArticleController articleController;
  @Autowired private ArticleService articleService;

  @PostMapping("/add")
  public Result add(Article article, MultipartFile tupian) {
    return articleController.add(article, tupian);
  }

  @GetMapping("/list")
  public Result list(Integer curPage, Integer pageSize, HttpServletRequest request) {
    Users users = (Users) request.getSession().getAttribute("users");
    String lname = users.getLname();
    return articleService.list(curPage, lname, pageSize);
  }

  @GetMapping("/del")
  public Result del(String aid) {
    return articleService.del(aid);
  }

  @GetMapping("/findByAid")
  public Result findByAid(Integer aid){
   return articleService.findByAid(aid);
  }
}
