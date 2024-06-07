package com.ucasnj.medsys.service.back;
import com.ucasnj.medsys.domain.Flink;
import com.ucasnj.medsys.utils.Result;

public interface FlinkService {
    Result list(Integer curPage, Integer pageSize);

    Result del(Integer id);

    Result add(Flink flink);

    Result update(Flink flink);

    Result findAll();
}
