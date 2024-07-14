package com.ldw.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ldw.Vo.FunctionRoleVo;
import com.ldw.dao.pojo.FunctionRole;

import java.util.List;

public interface FunctionRolerService extends IService<FunctionRole> {
  /**
   * 根据角色id查询权限表，看看他有多少权限
   * @param roleId
   * @return
   */
  List<FunctionRoleVo> findURList(Integer roleId);
}
