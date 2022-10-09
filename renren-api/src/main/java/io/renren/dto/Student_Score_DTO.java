package io.renren.dto;

import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@ApiModel(value = "学生分数")
public class Student_Score_DTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @Null(message="{id.null}", groups = AddGroup.class)
    @NotNull(message="{id不能为空}", groups = UpdateGroup.class)
    private Long id;

    @ApiModelProperty(value = "分数")
    private int score;

}
