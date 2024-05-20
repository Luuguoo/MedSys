package com.ucasnj.medsys.domain;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Atype {
    private Integer tid;
    private String tname;
    private Integer isNeedVip;

    private List<Article> articles;
}
