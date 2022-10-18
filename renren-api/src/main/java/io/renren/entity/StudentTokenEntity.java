package io.renren.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("stu_tb_token")
public class StudentTokenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
    /**
     * 学生ID
     */
    private Long studentId;
    /**
     * 学生token
     */
    private String token;
    /**
     * 过期时间
     */
    private Date expireDate;
    /**
     * 更新时间
     */
    private Date updateDate;

}
