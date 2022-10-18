package io.renren.entity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_article")
public class ArticleEntity {
    private static final long serialVersionUID = 1L;

    private int id;

    private String title;

    private String context;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long creator;

}
