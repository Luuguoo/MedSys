package com.ucasnj.medsys.service.back;
import com.ucasnj.medsys.domain.Users;
import com.ucasnj.medsys.util.Result;

import javax.servlet.http.HttpServletRequest;

public interface UsersService {
    Result list(Integer curPage, String lname, String username, Integer pageSize);

    Result del(String lname);

    Result add(Users users);

    Users findUsersByTel(String tel);

    Result update(Users users);

    Result login(String lname, String password, HttpServletRequest request);

    Result updatePass(String lname, String pass);

    Users findUsersByLname(String lname);

}
