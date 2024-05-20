package com.ucasnj.medsys.controller.front.publics;
import com.ucasnj.medsys.service.back.DiscussService;
import com.ucasnj.medsys.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/front/publics/discuss")
public class DiscussFrontController {
    @Autowired
    private DiscussService discussService;

    @GetMapping("/list")
    public Result list(Integer curPage, Integer aid, Integer pageSize) {
        return discussService.list(curPage,aid, pageSize);
    }
}
