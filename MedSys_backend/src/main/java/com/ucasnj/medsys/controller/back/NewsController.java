package com.ucasnj.medsys.controller.back;
import com.ucasnj.medsys.domain.News;
import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.service.back.NewsService;
import com.ucasnj.medsys.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/back/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/list")
    public Result list(Integer curPage, String name, Integer pageSize) {
        return newsService.list(curPage, name, pageSize);
    }

    @GetMapping("/del")
    public Result del(Integer id) {
        return newsService.del(id);
    }

    @PostMapping("/add")
    public Result add(News news) {
        try {
            news.setAddtime(new Date());
            return newsService.add(news);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.builder().code(2).msg("添加失败").build();
        }
    }

    @PostMapping("/update")
    public Result update(News news){
        try {
            return newsService.update(news);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.builder().code(2).msg("修改失败").build();
        }
    }
}
