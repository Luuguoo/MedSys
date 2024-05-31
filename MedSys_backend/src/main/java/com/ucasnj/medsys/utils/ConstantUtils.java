package com.ucasnj.medsys.utils;

public class ConstantUtils {

  //配置阿里云ip
  public static String aliyunIP = "";
  public static String localhost = "localhost";
  public static String ip = IPUtil.getIP().equals(aliyunIP) ? aliyunIP : localhost;
  public static String staticPath = "http://" + ip + ":8088/static";
  public static String backLoginAddr = "http://" + ip + ":8082/#/backLogin";
  public static String frontLoginAddr =
      "http://" + ip + ":8082/#/frontHome/frontInfo/frontyonghuzhongxinLogin";
  //如果运行的ip是阿里云的ip就用/root的路径，否则就是本地路径
  public static String filePath = aliyunIP.equals(ip) ? "/root/ucasnj/medsys/api/file/static/"
      : System.getProperty("user.dir") + "/src/main/resources/static/";
  public static String imagePath = filePath;
  public static String excelPath = filePath + "excel/";
}
