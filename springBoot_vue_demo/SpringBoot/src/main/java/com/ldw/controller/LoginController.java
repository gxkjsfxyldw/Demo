package com.ldw.controller;

import com.ldw.Vo.LoginUser;
import com.ldw.Vo.UpdateVo;
import com.ldw.common.Result;
import com.ldw.dao.pojo.User;
import com.ldw.service.UserService;
import com.ldw.utils.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录接口
     * @param loginUser
     * @return
     */
    @PostMapping("login")
    public Result<?> login(@RequestBody LoginUser loginUser){
        //登录校验
        User user = userService.login(loginUser);
        if(user==null){
            return Result.error("406","登录失败，账号或密码错误！");
        }
        //校验通过的话就存储到本地线程
        UserThreadLocal.put(user);
        return Result.success(user);
    }

    /**
     * 查看 list
     */
    @GetMapping("/list")
    public Result<?> selectUserList(){
       return Result.success(userService.list());
    }
    /**
     * 查看 byId
     */
    @GetMapping("/userById")
    public Result<?> selectUserById(@RequestParam Integer id){
        return Result.success(userService.selectUserById(id));
    }

    /**
     * 修改 update 整体信息
     */
    @PutMapping("/update")
    public Result<?> updateUserById(@RequestBody User user){
       int result= userService.updateUserInfo(user);
        if(result>=1){
            return Result.success("更新成功！");
        }
        return Result.error("407","参与有误！");
    }
    /**
     * 修改 update 修改密码和备注
     */
    @PutMapping("/updateS")
    public Result<?> updateSUserById(@RequestBody UpdateVo updateuser){
        int result= userService.updateSUserById(updateuser);
        if(result>=1){
            return Result.success("更新成功！");
        }
        return Result.error("407","参与有误！");
    }
    /**
     * 删除 delete
     */
    @DeleteMapping("/delete")
    public Result<?> deleteUserById(@RequestParam Integer id){
        int result = userService.deleteById(id);
        if(result>=1){
            return Result.success("删除成功！");
        }
        return Result.error("407","参与有误！");
    }
}
