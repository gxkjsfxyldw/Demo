package com.ldw.Vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class FunctionRoleVo {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String name;
    private Integer parentId;
    private String url;
    private String funDescription;

    private String roleName;
    private String roleDescription;

}
