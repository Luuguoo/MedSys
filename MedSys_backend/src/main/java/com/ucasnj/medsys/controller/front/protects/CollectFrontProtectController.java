package com.ucasnj.medsys.controller.front.protects;

import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.service.back.CollectService;
import com.ucasnj.medsys.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/front/protects/collect")
public class CollectFrontProtectController {
  @Autowired
  private CollectService collectService;

  @GetMapping("/list")
  public Result list(Integer curPage, Integer pageSize, HttpServletRequest request) {
    Users users = (Users) request.getSession().getAttribute("users");
    String lname = users.getLname();
    return collectService.list(curPage, lname, pageSize);
  }

  @GetMapping("/del")
  public Result del(String id) {
    return collectService.del(id);
  }

  @GetMapping("/add")
  public Result add(Integer aid,HttpServletRequest request){
    Users users = (Users) request.getSession().getAttribute("users");
    return collectService.add(aid,users.getLname());
  }
  
}
