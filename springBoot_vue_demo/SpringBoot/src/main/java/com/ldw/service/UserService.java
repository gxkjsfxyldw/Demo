package com.ldw.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ldw.Vo.LoginUser;
import com.ldw.Vo.UpdateVo;
import com.ldw.dao.pojo.User;


public interface UserService extends IService<User> {

    /**
     * 用户登录
     * @param loginUser
     * @return
     */
    User login(LoginUser loginUser);

    /**
     * * 根据id查询用户
     * @param id
     * @return
     */
    User selectUserById(Integer id);

    /**
     * * 更新用户信息
     * @param user
     * @return
     */
    int updateUserInfo(User user);

    /**
     * * 删除用户
     * @param id
     * @return
     */
    int deleteById(Integer id);

    int updateSUserById(UpdateVo updateuser);
}
