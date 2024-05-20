package com.ucasnj.medsys.controller.back;
import com.ucasnj.medsys.domain.Atype;
import com.ucasnj.medsys.domain.News;
import com.ucasnj.medsys.service.back.AtypeService;
import com.ucasnj.medsys.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/back/atype")
public class AtypeController {
    @Autowired
    private AtypeService atypeService;

    @GetMapping("/list")
    public Result list(Integer curPage, Integer pageSize) {
        return atypeService.list(curPage, pageSize);
    }

    @GetMapping("/del")
    public Result del(Integer tid) {
        return atypeService.del(tid);
    }

    @PostMapping("/add")
    public Result add(Atype atype) {
        try {
            return atypeService.add(atype);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.builder().code(2).msg("添加失败").build();
        }
    }

    @PostMapping("/update")
    public Result update(Atype atype){
        try {
            return atypeService.update(atype);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.builder().code(2).msg("修改失败").build();
        }
    }

    @GetMapping("findAll")
    public Result findAll(){
        return atypeService.findAll();
    }
}
