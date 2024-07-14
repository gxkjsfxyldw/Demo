package com.ldw.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("role")
public class Role implements Serializable {

    @TableId(value="id",type = IdType.NONE)
    private Integer id;
    private String roleName;
    private String description;

}
