package com.ucasnj.medsys.controller.front.protects;

import com.ucasnj.medsys.controller.back.ApplysController;
import com.ucasnj.medsys.domain.Applys;
import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.service.back.ApplysService;
import com.ucasnj.medsys.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/front/protects/applys")
public class ApplysFrontProtectController {
  @Autowired private ApplysService applysService;

  @GetMapping("/list")
  public Result list(Integer curPage, Integer pageSize, HttpServletRequest request) {
    HttpSession session = request.getSession();
    Users users = (Users) session.getAttribute("users");
    return applysService.list(curPage, users.getLname(), pageSize);
  }

  @GetMapping("/del")
  public Result del(String id) {
    return applysService.del(id);
  }

  @PostMapping("/add")
  public Result add(Integer aid,String xmemo,HttpServletRequest request){
    Users users = (Users) request.getSession().getAttribute("users");
    String lname = users.getLname();
    Applys applys = new Applys();
    applys.setAid(aid);
    applys.setLname(lname);
    applys.setXmemo(xmemo);
    applys.setAtime(new Date());
    applys.setFlag("待审核");
    return applysService.add(applys);

  }
}
