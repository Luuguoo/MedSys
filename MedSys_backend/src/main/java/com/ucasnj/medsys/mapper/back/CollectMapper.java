package com.ucasnj.medsys.mapper.back;
import com.ucasnj.medsys.domain.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CollectMapper {

    List<Collect> list(String lname);

    void del(String id);

    void add(Collect collect);

    Collect findByAidAndLname(Integer aid, String lname);
}
