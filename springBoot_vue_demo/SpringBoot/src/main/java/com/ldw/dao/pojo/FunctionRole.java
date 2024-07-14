package com.ldw.dao.pojo;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("function_role")
public class FunctionRole {

    @TableId(value="id",type = IdType.NONE)
    private Integer id;
    private Integer userId;
    private Integer functionId;
}
