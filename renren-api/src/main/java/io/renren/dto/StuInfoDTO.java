package io.renren.dto;

import io.renren.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiIgnore(value = "学生基本信息")
public class StuInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "姓名")
    private String realName;

    @ApiModelProperty(value = "头像")
    private String headUrl;

    @ApiModelProperty(value = "学校")
    private String name;

    @ApiModelProperty(value = "学校地址")
    private String schoolAddr;
}
