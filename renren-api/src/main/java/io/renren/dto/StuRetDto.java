package io.renren.dto;

import io.renren.common.validator.group.UpdateGroup;
import io.renren.entity.QuestionMoreEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Time;
import java.util.List;

@Data
@ApiModel(value = "学生信息")
public class StuRetDto implements Serializable{

        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "用户名")
        private String username;

        @ApiModelProperty(value = "姓名")
        private String realName;

        @ApiModelProperty(value = "测评记录")
        private List<QuestionMoreEntity> resultList;

}
