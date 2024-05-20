package com.ucasnj.medsys.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Article {
    private Integer aid;
    private Integer tid;
    private String title;
    private String photo;
    private String amemo;
    private String lname;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date atime;
    private String flag;
    private Integer flag2;
    //多对一关系
    private Atype atype;

    private Integer usersLevel;


}
