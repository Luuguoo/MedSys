package com.ucasnj.medsys.utils;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result<T> {

    /***
     * 1成功
     * 2失败
     */
    private Integer code;
    private String msg;
    private T data;
}
