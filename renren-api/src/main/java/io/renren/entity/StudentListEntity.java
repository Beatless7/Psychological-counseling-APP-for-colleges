package io.renren.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("sys_user")
public class StudentListEntity extends BaseEntity {
    @TableId
    private static final long serialVersionUID = 1L;

    private String realName;

    private Integer gender;

    private String mobile;

}
