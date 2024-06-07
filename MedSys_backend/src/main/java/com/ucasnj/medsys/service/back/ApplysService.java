package com.ucasnj.medsys.service.back;
import com.ucasnj.medsys.domain.Applys;
import com.ucasnj.medsys.utils.Result;

public interface ApplysService {

    Result list(Integer curPage, String name, String flag, Integer pageSize);

    Result del(String id);

    Result updateFlagById(Integer id, String checkResult);

    Result list(Integer curPage, String lname, Integer pageSize);

    Result add(Applys applys);
}
