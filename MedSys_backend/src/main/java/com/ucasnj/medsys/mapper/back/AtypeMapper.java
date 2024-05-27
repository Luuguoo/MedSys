package com.ucasnj.medsys.mapper.back;
import com.ucasnj.medsys.domain.Atype;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AtypeMapper {

    List<Atype> list();

    void del(Integer tid);

    void add(Atype atype);

    void update(Atype atype);

    Atype findByTid(Integer tid);
}
