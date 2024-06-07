package com.ucasnj.medsys.service.back;

import com.ucasnj.medsys.utils.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RecordsService {
  Result getReSou();

  Result add(String name);

  void download(HttpServletRequest request, HttpServletResponse response);
}
