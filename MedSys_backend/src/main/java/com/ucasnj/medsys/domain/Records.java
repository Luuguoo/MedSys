package com.ucasnj.medsys.domain;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Records {
    private Integer id;
    private String rname;
    //改词条出现的次数
    private Integer count;
}
