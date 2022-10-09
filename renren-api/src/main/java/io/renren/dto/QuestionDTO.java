package io.renren.dto;


import io.renren.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel(value = "问卷管理")
public class QuestionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @NotNull(message="{id.require}", groups = UpdateGroup.class)
    private Long id;

    @ApiModelProperty(value = "problems")
    private String problems;

    @ApiModelProperty(value = "yes")
    private String yes;

    @ApiModelProperty(value = "maybe")
    private String maybe;

    @ApiModelProperty(value = "no")
    private String no;
}
