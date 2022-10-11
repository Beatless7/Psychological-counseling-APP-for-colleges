package io.renren.dto;

import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * 学生注册表单
 *
 * @author Tjut team
 */

@Data
@ApiModel(value = "学生注册表单")
public class StudentRegisterDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    //@Null(message="{id.null}", groups = AddGroup.class)
    //@NotNull(message="{id不能为空}", groups = UpdateGroup.class)
    private Long id;

    @ApiModelProperty(value = "用户名")
    @NotBlank(message="用户名不能为空")
    private String username;

    @ApiModelProperty(value = "姓名", required = true)
    @NotBlank(message="{真实姓名不能为空}", groups = DefaultGroup.class)
    private String realName;

    @ApiModelProperty(value = "头像")
    private String headUrl;

    @ApiModelProperty(value = "性别   0：男   1：女    2：保密", required = true)
    @Range(min=0, max=2, message = "{sysuser.gender.range}", groups = DefaultGroup.class)
    private Integer gender;

    @ApiModelProperty(value = "邮箱")
    @Email(message="{sysuser.email.error}", groups = DefaultGroup.class)
    private String email;

    @ApiModelProperty(value = "手机号")
    @NotBlank(message="手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "密码")
    @NotBlank(message="密码不能为空")
    private String password;

    @ApiModelProperty(value = "学校学院id")
    private Long deptId;
}
