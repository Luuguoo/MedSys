package com.ucasnj.medsys.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Admin {
  private Integer aid;
  private String lname;
  private String pwd;
  private Integer flag;
}
