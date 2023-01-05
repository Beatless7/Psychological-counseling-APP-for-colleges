package io.renren.dto;


import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Time;

@Data
@ApiIgnore(value = "学生列表")
public class StudentListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @NotNull(message="{id.require}", groups = UpdateGroup.class)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "姓名")
    private String realName;

    @ApiModelProperty(value = "性别   0：男   1：女    2：保密", required = true)
    @Range(min=0, max=2, message = "{sysuser.gender.range}", groups = DefaultGroup.class)
    private Integer gender;

    @ApiModelProperty(value = "邮箱")
    @Email(message="{sysuser.email.error}", groups = DefaultGroup.class)
    private String email;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    /*@ApiModelProperty(value = "部门ID", required = true)
    @NotNull(message="{sysuser.deptId.require}", groups = DefaultGroup.class)
    private Long deptId;*/

    @ApiModelProperty(value = "部门名称")
    @NotNull(message="{sysuser.deptName.require}", groups = DefaultGroup.class)
    private String deptName;

    @ApiModelProperty(value = "预约状态   0:未预约   1:已预约",required = true)
    private Integer orderStatus;

    @ApiModelProperty(value = "可预约起始时间")
    private Time freeTimeBegin;

    @ApiModelProperty(value = "可预约结束时间")
    private Time freeTimeEnd;

}
