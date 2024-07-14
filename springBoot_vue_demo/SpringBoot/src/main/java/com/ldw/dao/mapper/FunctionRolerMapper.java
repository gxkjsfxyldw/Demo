package com.ldw.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ldw.Vo.FunctionRoleVo;
import com.ldw.dao.pojo.FunctionRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FunctionRolerMapper extends BaseMapper<FunctionRole> {
    //  得到角色授权的功能id的列表
    List<FunctionRoleVo> getListByRoleId(Integer roleId);
}
