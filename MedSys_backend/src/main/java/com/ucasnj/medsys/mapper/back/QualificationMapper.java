package com.ucasnj.medsys.mapper.back;

import com.ucasnj.medsys.domain.Qualification;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @作者：姚俊涛
 * @创建时间：19:42 2022/3/22
 */
@Mapper
@Repository
public interface QualificationMapper {

  boolean add(Qualification qualification);

  Qualification getByLname(String lname, Integer isDel);


  List<Qualification> list(Integer isDel);

  void updateStatusById(Integer id, Integer checkResult);

  Qualification findById(Integer id);
}
