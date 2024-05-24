package com.ucasnj.medsys.service.back;
import com.ucasnj.medsys.util.Result;

public interface CollectService {
    Result list(Integer curPage, String lname, Integer pageSize);

    Result del(String id);

    Result add(Integer aid, String lname);
}
