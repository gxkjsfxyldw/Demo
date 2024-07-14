package com.ldw.Handler;


import com.ldw.dao.pojo.User;
import com.ldw.service.UserService;
import com.ldw.utils.UserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * 作用：拦截指定的接口,将未登录的接口认证登录
 */
@Component
@Slf4j //打印日志
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在执行controller方法（Handler）之前执行的操作
        /*
           1.需要判断，请求接口路径，是否为 HandlerMethod（必须是controller方法）
           2.判断token是否为空，如果为空，未登录
           3.如果token不为空，登录验证  loginService checkToken
           4.如果认证成功，放行即可
         */
        if(!(handler instanceof HandlerMethod)){ //设置一些必须放行的资源路径
            //handler 可能是资源，RequestResourceHandler springboot 程序，访问静态资源 默认去classpath下的static目录去查询
            return true;//放行
        }
        //拦截未登录 token为空
        String userid = request.getHeader("Authorization");
        if(userid==null){
            return false;
        }
        User user = userService.selectUserById(Integer.valueOf(userid));
        UserThreadLocal.put(user);//将登录用户信息放入
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //如果不删除 ThreadLocal 中用完的信息，会有内存泄露的危险
        UserThreadLocal.remove();
    }
}

