package com.ucasnj.medsys.controller.back;

import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.service.back.QualificationService;
import com.ucasnj.medsys.utils.Result;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/back/qualification")
//检查用户资格
public class QualificationController {

  @Autowired
  private QualificationService qualificationService;

  @GetMapping("/list")
  public Result list(Integer curPage, Integer pageSize) {
    return qualificationService.list(curPage, pageSize);
  }

  @GetMapping("/check")
  public Result check(Integer id, Integer checkResult,HttpServletRequest request) {
    return qualificationService.check(id, checkResult,request.getSession());
  }

}
