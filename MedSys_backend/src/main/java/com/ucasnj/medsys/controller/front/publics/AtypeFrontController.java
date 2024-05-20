package com.ucasnj.medsys.controller.front.publics;
import com.ucasnj.medsys.service.back.AtypeService;
import com.ucasnj.medsys.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/front/publics/atype")
public class AtypeFrontController {
    @Autowired
    private AtypeService atypeService;

    @GetMapping("/findAll")
    public Result findAll(){
       return atypeService.findAll();
    }

    @GetMapping("/findAllAndArticle")
    public Result findAllAndArticle(){
        return atypeService.findAllAndArticle();
    }
}
