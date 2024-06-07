package com.ucasnj.medsys.controller.front.protects;

import com.ucasnj.medsys.controller.back.UsersController;
import com.ucasnj.medsys.domain.Qualification;
import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.service.back.QualificationService;
import com.ucasnj.medsys.service.back.UsersService;
import com.ucasnj.medsys.utils.Result;
import com.ucasnj.medsys.utils.ConstantUtils;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/front/protects/qualification")
public class QualificationFrontProtectController {

  @Autowired
  private QualificationService qualificationService;

  @GetMapping("/getByLname")
  public Result getByLname(HttpServletRequest request) {
    Users users = (Users) request.getSession().getAttribute("users");
    return qualificationService.getByLname(users.getLname());
  }


}
