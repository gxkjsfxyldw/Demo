package com.ldw.Handler;

import com.ldw.Vo.FunctionRoleVo;
import com.ldw.common.Result;
import com.ldw.service.FunctionRolerService;
import org.apache.commons.lang3.StringUtils;
import cn.hutool.json.JSON;
import com.ldw.dao.pojo.User;
import com.ldw.utils.UserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

/**
 * 接口拦截器
 * 作用：拦截指定的url路径，判断当前登录用户是否有权限访问该路径,
 * * 当前请求路径与用户在数据库里面的角色权限相等时，true放行
 */
@Component
@Slf4j
public class URLInterceptor implements HandlerInterceptor {

    @Autowired
    private FunctionRolerService functionRolerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(!(handler instanceof HandlerMethod)){ //设置一些必须放行的资源路径
            //访问静态资源 默认去classpath下的static目录去查询
            return true;//放行
        }

        //获取本地线程当前登录用户的信息
        User user = UserThreadLocal.get();
        Integer identity = user.getType();
        //获取当前请求url
        String requestURI = request.getRequestURI();

        //url可能会有？号所以需要处一下
        requestURI = StringUtils.split(requestURI, "?")[0];
//        requestURI = StringUtils.substringBeforeLast(requestURI, "/");

        log.info("=======================request start=========================");
        log.info("request: user:{}",user.getName());
        log.info("request: identity:{}",identity);
        log.info("request: url:{}",requestURI);
        log.info("request: method:{}",request.getMethod());
        log.info("=======================request end=========================");

        //超级管理员，所有权限
        if(Objects.equals(user.getType(), 1)){
            return true;//放行
        }

        //根据角色id查询权限表，看看他有多少权限
        List<FunctionRoleVo> urList = functionRolerService.findURList(identity);
        System.out.println("用户权限 权限列表 "+urList);

        //遍历这个用户的所有权限功能，看看当前登录用户具有的功能是否有权限访问这个资源
        //这个url是控制器那里指定的
        for (FunctionRoleVo functionRoleVo : urList) {
            //判断当前用户请求的rul是否存在权限表里面
            if(requestURI.equals(functionRoleVo.getUrl())){
                return true;//放行
            }
        }
        //设置拦截返回信息
        Result fail = Result.error("502", "无权限访问！");
        response.setContentType("Application/json;charset=utf-8");
        response.getWriter().println(fail);
        return false;//拦截
    }
}

