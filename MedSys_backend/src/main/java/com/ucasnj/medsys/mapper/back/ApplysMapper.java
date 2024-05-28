package com.ucasnj.medsys.mapper.back;

import com.ucasnj.medsys.domain.Applys;
import com.ucasnj.medsys.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ApplysMapper {
  List<Applys> list(String name, String flag);

  void del(String id);

  void updateFlagById(Integer id, String checkResult);

  Applys findById(Integer id);

  List<Applys> listByLname(String lname);

    void add(Applys applys);
}
