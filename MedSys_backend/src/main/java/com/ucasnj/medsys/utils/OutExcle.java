package com.ucasnj.medsys.utils;

import com.ucasnj.medsys.domain.Flink;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//将对象列表转换成Excel文件并下载
public class OutExcle {

  public static void main(String[] args) {

    Flink flink1 = new Flink();
    flink1.setId(1);
    flink1.setHttp("http1");
    flink1.setTitle("test http1");
    Flink flink2 = new Flink();
    flink2.setId(2);
    flink2.setHttp("http2");
    flink2.setTitle("test http2");
    List<Flink> stus = new ArrayList<>();
    stus.add(flink1);
    stus.add(flink2);     //list集合里添加两个对象
    String s = ConstantUtils.excelPath;
  }


  /**
   * 获取属性值
   *
   * @param fieldName 字段名称
   * @param o         对象
   * @return Object
   */
  private static Object getFieldValueByName(String fieldName, Object o) {
    try {
      String firstLetter = fieldName.substring(0, 1).toUpperCase();
      String getter = "get" + firstLetter + fieldName.substring(1);    //获取方法名
      Method method = o.getClass().getMethod(getter, new Class[]{});  //获取方法对象
      Object value = method.invoke(o, new Object[]{});    //用invoke调用此对象的get字段方法
      return value;  //返回值
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * 将list集合转成Excel文件
   *
   * @param list 对象集合
   * @param path 输出路径
   * @return 返回文件路径
   */
  public static String createExcel(List<? extends Object> list, String path) {
    String result = "";
    if (list.size() == 0 || list == null) {
      result = "没有对象信息";
    } else {
      Object o = list.get(0);
      Class<? extends Object> clazz = o.getClass();
      String className = clazz.getSimpleName();
      java.lang.reflect.Field[] fields = clazz.getDeclaredFields();    //这里通过反射获取字段数组
      File folder = new File(path);
      if (!folder.exists()) {
        folder.mkdirs();
      }
      String fileName = UUID.randomUUID().toString().replaceAll("-", "");
      String name = fileName.concat(".xls");
      WritableWorkbook book = null;
      File file = null;
      try {
        file = new File(path.concat(File.separator).concat(name));
        book = Workbook.createWorkbook(file);  //创建xls文件
        WritableSheet sheet = book.createSheet(className, 0);
        int i = 0;  //列
        int j = 0;  //行
        for (java.lang.reflect.Field f : fields) {
          j = 0;
          Label label = new Label(i, j, f.getName());   //这里把字段名称写入excel第一行中
          sheet.addCell(label);
          j = 1;
          for (Object obj : list) {
            Object temp = getFieldValueByName(f.getName(), obj);
            String strTemp = String.valueOf(j);//一开始的id为空 默认成序号
            if (temp != null) {
              strTemp = temp.toString();
            }
            sheet.addCell(new Label(i, j, strTemp));  //把每个对象此字段的属性写入这一列excel中
            j++;
          }
          i++;
        }
        book.write();
        result = file.getPath();
      } catch (Exception e) {
        result = "SystemException";
        e.printStackTrace();
      } finally {
        fileName = null;
        name = null;
        folder = null;
        file = null;
        if (book != null) {
          try {
            book.close();
          } catch (WriteException e) {
            result = "WriteException";
            e.printStackTrace();
          } catch (IOException e) {
            result = "IOException";
            e.printStackTrace();
          }
        }
      }

    }

    return result;   //最后输出文件路径
  }


  public static String download(HttpServletRequest request, HttpServletResponse response, String url) {
    File fileurl = new File(url);
    //浏览器下载后的文件名称showValue,从url中截取到源文件名称以及，以及文件类型，如board.docx;
    String showValue = "热搜率导出文件.xls";
    InputStream inStream = null;
    try {
      //将文件读入文件流
      inStream = new FileInputStream(fileurl);
      //获得浏览器代理信息
      final String userAgent = request.getHeader("USER-AGENT");
      //判断浏览器代理并分别设置响应给浏览器的编码格式
      String finalFileName = null;
      if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {//IE浏览器
        finalFileName = URLEncoder.encode(showValue, "UTF8");
      } else if (userAgent.contains("Mozilla")) {//google,火狐浏览器
        finalFileName = new String(showValue.getBytes(), "ISO8859-1");
      } else {
        finalFileName = URLEncoder.encode(showValue, "UTF8");//其他浏览器
      }
      //设置HTTP响应头
      response.reset();//重置 响应头
      response.setContentType("application/x-download");//告知浏览器下载文件，而不是直接打开，浏览器默认为打开
      response.addHeader("Content-Disposition",
          "attachment;filename=\"" + finalFileName + "\"");//下载文件的名称

      // 循环取出流中的数据
      byte[] b = new byte[1024];
      int len;
      while ((len = inStream.read(b)) > 0) {
        response.getOutputStream().write(b, 0, len);
      }
      response.getOutputStream().close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        inStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return "";
  }

  public static void deleteFile(String filePath) {
    File file = new File(filePath);
    if (file.exists()) {
      file.delete();
    }
  }

}

