package com.ucasnj.medsys.controller.front.publics;

import com.ucasnj.medsys.service.back.FlinkService;
import com.ucasnj.medsys.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/front/publics/flink")
@CrossOrigin
public class FlinkFrontController {
  @Autowired private FlinkService flinkService;

  @RequestMapping("/findAll")
  public Result findAll() {
    return flinkService.findAll();
  }
}
