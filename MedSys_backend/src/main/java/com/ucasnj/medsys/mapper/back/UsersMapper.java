package com.ucasnj.medsys.mapper.back;

import com.ucasnj.medsys.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UsersMapper {

  List<Users> list(String lname, String username);

  void del(String lname);

  void add(Users users);

  Users findUsersByTel(String tel);

  void update(Users users);

  Users findUsersByLname(String lname);

  Users findUsersAllByLname(String lname);

  void updatePass(String lname, String pass);

  void updateLevelByLname(String lname);

  Integer findUsersLevelByLname(String lname);
}
