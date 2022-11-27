package io.renren.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.joda.time.DateTime;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("more_question")
public class QuestionMoreEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String psyStates;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date workTime;
}
