package com.ucasnj.medsys.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//获取当前设备的IP地址
public class IPUtil {

  public static String getIP() {
    String ip = "http://pv.sohu.com/cityjson?ie=utf-8";
    String inputLine = "";
    String read = "";
    String toIp = "";
    try {
      URL url = new URL(ip);
      HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
      BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
      while ((read = in.readLine()) != null) {
        inputLine += read;
      }
      String objJson = inputLine.substring(inputLine.indexOf("=") + 1, inputLine.length() - 1);
      JSONObject jsonObj = JSON.parseObject(objJson);
      toIp = jsonObj.getString("cip");
    } catch (Exception e) {
      toIp = "";
    }
    return toIp;
  }
}