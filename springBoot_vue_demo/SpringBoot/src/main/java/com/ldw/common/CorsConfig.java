package com.ldw.common;

import com.ldw.Handler.LoginInterceptor;
import com.ldw.Handler.URLInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig  implements WebMvcConfigurer {

    @Autowired
    private URLInterceptor urlInterceptor;
    @Autowired
    private LoginInterceptor loginInterceptor;

    //解决后台跨域的问题
    //当前跨域请求最大有效时常，默认1天
    private static final long MAX_AGE=24*60*60;

    private CorsConfiguration buildConfig(){
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");//设置访问源地址
        corsConfiguration.addAllowedHeader("*");//设置访问源请求头
        corsConfiguration.addAllowedMethod("*");//设置访问源请求方法
        corsConfiguration.setMaxAge(MAX_AGE);
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter(){//注意CorsFilter不要导入错
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",buildConfig());//对接配置跨域设置
        return new CorsFilter(source);
    }

    //过滤器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        this.loginInterceptor(registry);
        // 接口请求权限拦截
        this.URLInterceptor(registry);
    }
    //登录拦截
    private void loginInterceptor(InterceptorRegistry registry){
        registry.addInterceptor(this.loginInterceptor)
                .addPathPatterns("/test")  //未登录不可访问
                .addPathPatterns("/**") //拦截全部请求
                .excludePathPatterns("/login");//过滤登录接口
    }

    //接口请求拦截
    private void URLInterceptor(InterceptorRegistry registry){
        registry.addInterceptor(this.urlInterceptor)
                .addPathPatterns("/**")  //拦截所有请求
                .excludePathPatterns("/login");//过滤登录接口
    }

}
