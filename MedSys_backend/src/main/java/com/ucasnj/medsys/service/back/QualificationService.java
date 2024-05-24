package com.ucasnj.medsys.service.back;

import com.ucasnj.medsys.domain.Qualification;
import com.ucasnj.medsys.util.Result;
import javax.servlet.http.HttpSession;

/**
 * @作者：姚俊涛
 * @创建时间：19:43 2022/3/22
 */
public interface QualificationService {

  Result add(Qualification qualification);

  Result getByLname(String lname);

  Result list(Integer curPage, Integer pageSize);

  Result check(Integer id, Integer checkResult, HttpSession session);
}
