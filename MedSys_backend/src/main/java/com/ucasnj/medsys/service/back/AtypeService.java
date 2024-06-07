package com.ucasnj.medsys.service.back;
import com.ucasnj.medsys.domain.Atype;
import com.ucasnj.medsys.utils.Result;

public interface AtypeService {
    Result list(Integer curPage, Integer pageSize);

    Result del(Integer tid);

    Result add(Atype atype);

    Result update(Atype atype);

    Result findAll();

    Result findAllAndArticle();
}
