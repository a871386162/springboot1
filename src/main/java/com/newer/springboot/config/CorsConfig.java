package com.newer.springboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    //定义一个数组  配置我们访问的源
    public static  String[] originVals={
      "127.0.0.1:8080",
      "localhost:8080",
    };

    /**
     * 配置跨域的过滤器
     */
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //this.addAllowOrigin(corsConfiguration);
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowCredentials(true);//允许session跨域配置
        corsConfiguration.addAllowedOrigin("*"); //所有的请求能可以访问
        source.registerCorsConfiguration("/**",corsConfiguration);
        return  new CorsFilter(source);
    }

    private void addAllowOrign( CorsConfiguration corsConfiguration) {
        for(String orign:originVals){
            corsConfiguration.addAllowedOrigin("http://"+orign);
            corsConfiguration.addAllowedOrigin("https://"+orign);
        }
    }
}
