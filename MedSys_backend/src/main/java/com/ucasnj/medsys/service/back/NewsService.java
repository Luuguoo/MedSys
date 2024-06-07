package com.ucasnj.medsys.service.back;
import com.ucasnj.medsys.domain.News;
import com.ucasnj.medsys.utils.Result;

public interface NewsService {
    Result list(Integer curPage, String name, Integer pageSize);

    Result del(Integer id);

    Result add(News news);

    Result update(News news);
}
