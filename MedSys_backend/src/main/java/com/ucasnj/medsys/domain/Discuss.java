package com.ucasnj.medsys.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户评论
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Discuss {
    private Integer id;
    private Integer aid;
    private String lname;
    private String dmemo;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date dtime;

    private Users users;
}
