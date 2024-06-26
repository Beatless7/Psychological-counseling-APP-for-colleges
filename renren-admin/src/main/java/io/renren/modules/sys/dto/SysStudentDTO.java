// powered by 天津理工大学心理辅导团队

package io.renren.modules.sys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
import java.util.Date;

/**
 * 学生管理
 */
@Data
@ApiModel(value = "学生管理")
public class SysStudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "id")
	@Null(message="{id.null}", groups = AddGroup.class)
	@NotNull(message="{id.require}", groups = UpdateGroup.class)
	private Long id;

	@ApiModelProperty(value = "用户名", required = true)
	@NotBlank(message="{sysuser.username.require}", groups = DefaultGroup.class)
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
	private String mobile;

	@ApiModelProperty(value = "心理状态")
	private String psyStates;

	@ApiModelProperty(value = "部门ID", required = true)
	@NotNull(message="{sysuser.deptId.require}", groups = DefaultGroup.class)
	private Long deptId;

	@ApiModelProperty(value = "状态  0：停用    1：正常", required = true)
	@Range(min=0, max=1, message = "{sysuser.status.range}", groups = DefaultGroup.class)
	private Integer status;

	@ApiModelProperty(value = "创建时间")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Date createDate;

	@ApiModelProperty(value = "部门名称")
	private String deptName;

}