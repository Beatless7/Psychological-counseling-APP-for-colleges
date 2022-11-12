package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

/**
 *音视频
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_mv")
public class SysArticleEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 序号
     */
    private Long id;
    /**
     * 文章标题
     */
    private String title;
    /**
    文章内容
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String context;
    /**
     * 创建者
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long creator;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date creator_date;
}
