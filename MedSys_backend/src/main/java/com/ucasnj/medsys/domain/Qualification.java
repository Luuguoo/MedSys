package com.ucasnj.medsys.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Qualification {

  private Integer id;
  private String lname;
  private String pic;
  /**
   * 0:正在审核 1:审核成功  2:审核失败
   */
  private Integer status;
  private Integer isDel;

}
