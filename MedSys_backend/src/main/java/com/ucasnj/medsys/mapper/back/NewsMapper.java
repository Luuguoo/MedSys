package com.ucasnj.medsys.mapper.back;
import com.ucasnj.medsys.domain.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NewsMapper {

    List<News> list(String name);

    void del(Integer id);

    void add(News news);

    void update(News news);
}
