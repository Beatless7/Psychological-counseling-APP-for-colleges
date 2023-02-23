package io.renren.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;

@Data
@ApiModel(value = "教师基本信息")
public class UserInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "姓名")
    private String realName;

    @ApiModelProperty(value = "头像")
    private String headUrl;

    @ApiModelProperty(value = "工作开始时间")
    private Time freeTimeBegin;

    @ApiModelProperty(value = "工作结束时间")
    private Time freeTimeEnd;

    @ApiModelProperty(value = "学校地址")
    private String schoolAddr;
}
