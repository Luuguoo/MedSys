package com.ucasnj.medsys.controller.back;
import com.ucasnj.medsys.domain.Flink;
import com.ucasnj.medsys.service.back.FlinkService;
import com.ucasnj.medsys.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/back/flink")
public class FlinkController {
    @Autowired
    private FlinkService flinkService;

    @GetMapping("/list")
    public Result list(Integer curPage, Integer pageSize) {
        return flinkService.list(curPage, pageSize);
    }

    @GetMapping("/del")
    public Result del(Integer id) {
        return flinkService.del(id);
    }

    @PostMapping("/add")
    public Result add(Flink flink) {
        try {
            return flinkService.add(flink);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.builder().code(2).msg("添加失败").build();
        }
    }

    @PostMapping("/update")
    public Result update(Flink flink){
        try {
            return flinkService.update(flink);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.builder().code(2).msg("修改失败").build();
        }
    }
}
