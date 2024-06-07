package com.ucasnj.medsys.controller.back;
import com.ucasnj.medsys.service.back.DiscussService;
import com.ucasnj.medsys.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/back/discuss")
//评论区
public class DiscussController {
    @Autowired
    private DiscussService discussService;

    @GetMapping("/list")
    public Result list(Integer curPage,String name, Integer pageSize) {
        return discussService.list(curPage,name, pageSize);
    }
    @GetMapping("/del")
    public Result del(Integer id) {
        return discussService.del(id);
    }
}
