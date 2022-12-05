package io.renren.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@ApiModel("学生信息")
public class UserStuDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "手机号")
    @NotBlank(message="手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "学校名称")
    @NotBlank(message="学校不能为空")
    private String deptName;
}
