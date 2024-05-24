package com.ucasnj.medsys.service.back;
import com.ucasnj.medsys.domain.Discuss;
import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.util.Result;

public interface DiscussService {
    Result list(Integer curPage, String name, Integer pageSize);

    Result list(Integer curPage, Integer aid, Integer pageSize);

    Result del(Integer id);


    Result list(Integer curPage, Integer pageSize, String lname);

    Result add(Discuss discuss);
}
