package io.renren.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生
 *
 * @author Tjut team
 */

@Data
@TableName("sys_student")
public class StudentEntity implements Serializable {
    @TableId
    private  long id = 1L;

    private String username;

    private String password;

    private String realName;

    private String headUrl;

    private Integer gender;

    private String email;

    private String mobile;

    private Long deptId;

    private Integer superAdmin;

    private String psyStates;

    private Integer status;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date creator;

    @TableField(exist=false)
    private String deptName;
}