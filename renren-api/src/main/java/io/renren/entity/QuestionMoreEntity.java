package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.joda.time.DateTime;

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("more_question")
public class QuestionMoreEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String psyStates;
    private DateTime workTime;
}
