package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_question")
public class SysQuestionEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String problems;
    private String yes;
    private String maybe;
    private String no;
}
