package com.ldw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldw.Vo.FunctionRoleVo;
import com.ldw.dao.mapper.FunctionRolerMapper;
import com.ldw.dao.mapper.UserMapper;
import com.ldw.dao.pojo.FunctionRole;
import com.ldw.dao.pojo.User;
import com.ldw.service.FunctionRolerService;
import com.ldw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionRolerServiceIpml  extends ServiceImpl<FunctionRolerMapper, FunctionRole> implements FunctionRolerService {


    @Autowired
    FunctionRolerMapper functionRolerMapper;


    /**
     * 根据角色id查询权限表，看看他有多少权限
     * @param roleId
     * @return
     */
    @Override
    public List<FunctionRoleVo> findURList(Integer roleId) {
        List<FunctionRoleVo> listByRoleId = functionRolerMapper.getListByRoleId(roleId);
        return listByRoleId;
    }
}
