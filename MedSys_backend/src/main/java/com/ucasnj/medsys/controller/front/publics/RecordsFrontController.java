package com.ucasnj.medsys.controller.front.publics;

import com.ucasnj.medsys.service.back.RecordsService;
import com.ucasnj.medsys.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/front/publics/records")
public class RecordsFrontController {
  @Autowired private RecordsService recordsService;

  @GetMapping("/getTrending")
  public Result getTrending() {
    return recordsService.getTrending();
  }
  @GetMapping("/add")
  public Result add(String name){
    return recordsService.add(name);
  }
}
