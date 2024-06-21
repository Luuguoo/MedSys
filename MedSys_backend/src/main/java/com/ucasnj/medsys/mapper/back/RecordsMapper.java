package com.ucasnj.medsys.mapper.back;
import com.ucasnj.medsys.domain.Records;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RecordsMapper {
    List<Records> getTrending();

    void add(String name);

}
