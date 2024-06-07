package com.ucasnj.medsys.controller.front.protects;

import com.ucasnj.medsys.domain.Discuss;
import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.service.back.ApplysService;
import com.ucasnj.medsys.service.back.DiscussService;
import com.ucasnj.medsys.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/front/protects/discuss")
public class DiscussFrontProtectController {
  @Autowired private DiscussService discussService;

  @GetMapping("/list")
  public Result list(Integer curPage, Integer pageSize, HttpServletRequest request) {
    Users users = (Users) request.getSession().getAttribute("users");
    return discussService.list(curPage, pageSize, users.getLname());
  }

  @GetMapping("/del")
  public Result del(Integer id) {
    return discussService.del(id);
  }

  @PostMapping("/add")
  public Result add(Integer aid, String content, HttpServletRequest request) {
    Users users = (Users) request.getSession().getAttribute("users");
    Discuss discuss = new Discuss();
    discuss.setAid(aid);
    discuss.setLname(users.getLname());
    discuss.setDmemo(content);
    discuss.setDtime(new Date());
    return discussService.add(discuss);
  }
}
