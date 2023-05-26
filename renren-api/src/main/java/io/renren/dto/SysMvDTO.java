package io.renren.dto;

import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * 音视频管理
 */
@Data
@ApiModel(value = "音视频管理")
public class SysMvDTO {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Null(message="{id.null}", groups = AddGroup.class)
    @NotNull(message="{id.require}", groups = UpdateGroup.class)
    private Long id;

    @ApiModelProperty(value = "类型", required = true)
    @NotBlank(message="类型不为空", groups = DefaultGroup.class)
    private String types;

    @ApiModelProperty(value = "地址", required = true)
    @NotBlank(message="地址不为空", groups = DefaultGroup.class)
    private String addr;

    @ApiModelProperty(value = "封面地址", required = true)
    @NotBlank(message="封面地址不为空", groups = DefaultGroup.class)
    private char addr2;

    @ApiModelProperty(value = "标题", required = true)
    @NotBlank(message="标题不为空", groups = DefaultGroup.class)
    private char title;

    @ApiModelProperty(value = "害怕", required = true)
    private int fear;

    @ApiModelProperty(value = "开心", required = true)
    private int happy;

    @ApiModelProperty(value = "悲伤", required = true)
    private int sad;

    @ApiModelProperty(value = "生气", required = true)
    private int angry;

    @ApiModelProperty(value = "反感", required = true)
    private int disgust;

    @ApiModelProperty(value = "惊喜", required = true)
    private int surprise;

    @ApiModelProperty(value = "标题", required = true)
    private int netural;
}
