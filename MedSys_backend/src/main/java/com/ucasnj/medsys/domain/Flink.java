package com.ucasnj.medsys.domain;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Flink {
    private Integer id;
    private String title;
    private String http;
}
