package com.ucasnj.medsys.controller.back;

import com.ucasnj.medsys.service.back.ApplysService;
import com.ucasnj.medsys.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/back/applys")
//文章修改申请
public class ApplysController {
  @Autowired private ApplysService applysService;

  @GetMapping("/del")
  public Result del(String id) {
    return applysService.del(id);
  }

  @GetMapping("/list")
  public Result list(Integer curPage, String name, String check, Integer pageSize) {
    System.out.println("check = " + check);
    return applysService.list(curPage, name, check, pageSize);
  }
  @GetMapping("/check")
  public Result check(Integer id,String checkResult){
    return applysService.updateFlagById(id,checkResult);
  }



}
