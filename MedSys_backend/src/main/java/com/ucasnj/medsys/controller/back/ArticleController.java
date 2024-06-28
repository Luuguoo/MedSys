package com.ucasnj.medsys.controller.back;

import com.ucasnj.medsys.domain.Article;
import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.service.back.ArticleService;
import com.ucasnj.medsys.utils.Result;
import com.ucasnj.medsys.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/back/article")
//处理与文章相关的请求操作
public class ArticleController {

  @Autowired
  private ArticleService articleService;

  @GetMapping("/check")
  public Result check(Integer aid, String checkResult) {
    return articleService.updateFlagByAid(aid, checkResult);
  }

  @GetMapping("/list")
  public Result list(Integer curPage, String flag, Integer tid, String title, String lname, Integer pageSize) {
    return articleService.list(curPage, flag, tid, title, lname, pageSize);
  }

  @GetMapping("/del")
  public Result del(String aid) {
    return articleService.del(aid);
  }

  @PostMapping("/update")
  public Result update(Article article, MultipartFile tupian) {
    if (tupian != null) {
      File path = new File(ConstantUtils.imagePath + "upload/");
      if (!path.exists()) {
        path.mkdirs();
      }
      String filename = tupian.getOriginalFilename();
      String exName = filename.substring(filename.lastIndexOf("."));
      filename = UUID.randomUUID().toString().replaceAll("-", "") + exName;

      File file = new File(path, filename);
      try {
        tupian.transferTo(file);
        article.setPhoto("/upload/" + filename);
      } catch (IOException e) {
        e.printStackTrace();
        return Result.builder().code(2).msg("修改失败").build();
      }
    } else {
      article.setPhoto(article.getPhoto().substring(article.getPhoto().lastIndexOf("/upload")));
    }
    return articleService.update(article);
  }


  @PostMapping("/add")
  public Result add(Article article, MultipartFile tupian) {
    File path = new File(ConstantUtils.imagePath + "upload/");
    if (!path.exists()) {
      path.mkdirs();
    }
    String filename = tupian.getOriginalFilename();
    String exName = filename.substring(filename.lastIndexOf("."));
    //UUID
    filename = UUID.randomUUID().toString().replaceAll("-", "") + exName;
    // 使用时间戳生成文件名
    //filename = System.currentTimeMillis() + exName;

    File file = new File(path, filename);
    try {
      tupian.transferTo(file);
      article.setPhoto("/upload/" + filename);
      article.setAtime(new Date());
      if (article.getFlag2() == 1) {
        article.setFlag("审核通过");
      } else {
        article.setFlag("待审核");
      }
      return articleService.add(article);
    } catch (IOException e) {
      e.printStackTrace();
      return Result.builder().code(2).msg("添加失败").build();
    }
  }
}
