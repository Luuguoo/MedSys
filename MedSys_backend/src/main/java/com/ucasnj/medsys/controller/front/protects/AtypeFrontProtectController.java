package com.ucasnj.medsys.controller.front.protects;

import com.ucasnj.medsys.controller.back.ArticleController;
import com.ucasnj.medsys.controller.back.AtypeController;
import com.ucasnj.medsys.domain.Article;
import com.ucasnj.medsys.service.back.AtypeService;
import com.ucasnj.medsys.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/front/protects/atype")
public class AtypeFrontProtectController {
  @Autowired private AtypeService atypeService;

  @GetMapping("/findAll")
  public Result findAll(){
    return atypeService.findAll();
  }
}
