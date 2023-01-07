package io.renren.dto;

import io.renren.common.validator.group.UpdateGroup;
import io.renren.entity.QuestionMoreEntity;
import io.renren.entity.StudentEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "教师列表")
public class UserListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @NotNull(message="{id.require}", groups = UpdateGroup.class)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "姓名")
    private String realName;

    @ApiModelProperty(value = "预约时间")
    private Time orderTime;

    @ApiModelProperty(value = "预约学生的ID")
    private Long orderStudentId;

    @ApiModelProperty(value = "预约状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "学生信息")
    private List<StudentEntity> resultList;
}
