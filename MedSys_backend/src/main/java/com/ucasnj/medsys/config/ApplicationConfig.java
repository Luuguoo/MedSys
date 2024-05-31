package com.ucasnj.medsys.config;

import com.ucasnj.medsys.interceptor.AdminInterceptor;
import com.ucasnj.medsys.interceptor.UsersInterceptor;
import com.ucasnj.medsys.utils.ConstantUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class ApplicationConfig extends WebMvcConfigurationSupport {

  /**
   * 全局配置 axios 跨域请求 addMapping：配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径 allowedOrigins：允许所有的请求域名访问跨域资源，可以固定单条或者多条内容，
   * 如：”http://www.xxx.com“，只有该域名可以访问我们的跨域资源 allowCredentials：是否允许用户发送、处理 cookie
   * allowedMethods：允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等 allowedHeaders：允许所有的请求header访问，可以自定义设置任意请求头信息
   * maxAge：预检请求的有效期，单位为秒。有效期内，不会重复发送预检请求 当预检请求通过后，浏览器会发送真实请求到服务器。这就实现了跨域请求
   *
   * @param registry
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    //配置了多个允许的源（包括阿里云IP和本地主机的不同端口）
    String[] origins = {
        "http://"+ConstantUtils.aliyunIP+":8080",
        "http://"+ConstantUtils.aliyunIP+":8081",
        "http://"+ConstantUtils.aliyunIP+":8082",
        "http://"+ConstantUtils.aliyunIP+":8083",
        "http://"+ConstantUtils.aliyunIP+":8084",
        "http://localhost:8080",
        "http://localhost:8081",
        "http://localhost:8082",
        "http://localhost:8083",
        "http://localhost:8084"};
    registry
        .addMapping("/**")
        .allowedOrigins(origins)
        .allowCredentials(true)
        .allowedMethods("*")
        .allowedHeaders("*")
        .maxAge(3600);
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("/static/**").addResourceLocations("file:" + ConstantUtils.filePath);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 注册AdminInterceptor拦截器
    InterceptorRegistration adminRegistration = registry.addInterceptor(new AdminInterceptor());
    adminRegistration.addPathPatterns("/back/**"); // back下的所有路径都被拦截
    adminRegistration.excludePathPatterns( // 添加不拦截路径
        "/back/login", // 登录路径
        "/back/logout", // 登出路径
        "/back/users/add", // 用户注册路径
        "/static/**" // 静态资源
    );

    // 注册UsersInterceptor拦截器
    InterceptorRegistration usersRegistration = registry.addInterceptor(new UsersInterceptor());
    usersRegistration.addPathPatterns("/front/protects/**"); // front/protects下的所有路径都被拦截
    usersRegistration.excludePathPatterns( // 添加不拦截路径
        "/front/protects/users/logout", // 登出路径
        "/static/**" // 静态资源
    );
  }
}
