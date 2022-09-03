package io.renren.modules.sys.dto;

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
//    @Null(message="{id.null}", groups = AddGroup.class)
    @NotNull(message="{id.require}", groups = UpdateGroup.class)
    private Long id;

    @ApiModelProperty(value = "类型", required = true)
    @NotBlank(message="类型不为空", groups = DefaultGroup.class)
    private String types;

    @ApiModelProperty(value = "地址", required = true)
    @NotBlank(message="地址不为空", groups = DefaultGroup.class)
    private String addr;
}
