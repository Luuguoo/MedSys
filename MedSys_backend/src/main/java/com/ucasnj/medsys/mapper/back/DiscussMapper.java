package com.ucasnj.medsys.mapper.back;
import com.ucasnj.medsys.domain.Discuss;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DiscussMapper {
    List<Discuss> list(String name);

    void del(Integer id);

    List<Discuss> findByAid(Integer aid);


    List<Discuss> findAllByLname(String lname);

    void add(Discuss discuss);
}
