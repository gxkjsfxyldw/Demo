package com.ldw.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldw.Vo.LoginUser;
import com.ldw.Vo.UpdateVo;
import com.ldw.dao.mapper.UserMapper;
import com.ldw.dao.pojo.User;
import com.ldw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * *
      * @param loginUser
     * @return
     * 账号校验，密码校验
     *
     * * * *
     */
    @Override
    public User login(LoginUser loginUser) {
        //将用户名和密码与数据库相比较，只有账号和密码都对的情况下才能是登录成功
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getName, loginUser.getName())
                .eq(User::getPwd, loginUser.getPwd())
        );
        return user;
    }

    /**
     * * 根据id查询用户
     * @param id
     * @return
     */
    @Override
    public User selectUserById(Integer id) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("id","name","type","memo").eq("id",id);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

    /**
     * * 更新用户信息
     * @param user
     * @return
     */
    @Override
    public int updateUserInfo(User user) {
        int i = userMapper.updateById(user);
        return i;
    }

    /**
     * * 删除用户
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        //当id一致，并且类型不等于1 时，即 删除的不是管理员自己
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        wrapper.ne("type", 1);
        int i = userMapper.delete(wrapper);
        return i;
    }

    @Override
    public int updateSUserById(UpdateVo updateuser) {

        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id", updateuser.getId());
        updateWrapper.set("memo", updateuser.getMemo());
        updateWrapper.set("pwd", updateuser.getPwd());
        int i = userMapper.update(null, updateWrapper);
        return i;
    }
}
