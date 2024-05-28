package com.ucasnj.medsys.mapper.back;

import com.ucasnj.medsys.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {
  Admin getAdminByUsername(String lname);

  void updatePass(Integer aid, String pass);
}
