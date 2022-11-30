package io.renren.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@ApiModel("修改密码")
public class PasswordDTO implements Serializable {
    private static final long serialVersionUID = 1L;

//    @ApiModelProperty(value = "id")
//    @Null(message="{id.null}", groups = AddGroup.class)
//    @NotNull(message="{id不能为空}", groups = UpdateGroup.class)
//    private Long id;

    @ApiModelProperty(value = "原密码")
    @NotBlank(message="密码不能为空")
    private String password;

    @ApiModelProperty(value = "新密码")
    @NotBlank(message="密码不能为空")
    private String newPassword;

}
