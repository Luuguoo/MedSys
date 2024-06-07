package com.ucasnj.medsys.controller.front.publics;

import com.ucasnj.medsys.service.back.NewsService;
import com.ucasnj.medsys.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/front/publics/news")
public class NewsFrontController {
  @Autowired private NewsService newsService;

  @GetMapping("/list")
  public Result list(
      Integer curPage, @RequestParam(defaultValue = "") String name, Integer pageSize) {
    return newsService.list(curPage, name, pageSize);
  }
}
