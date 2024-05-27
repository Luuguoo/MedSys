package com.ucasnj.medsys.mapper.back;
import com.ucasnj.medsys.domain.Flink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FlinkMapper {

    List<Flink> list();

    void del(Integer id);

    void add(Flink flink);

    void update(Flink flink);
}
