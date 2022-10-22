package io.renren.modules.sys.dto;

import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 文章
 */
@Data
@ApiModel(value = "文章管理")
public class SysArticleDTO {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
//    @Null(message="{id.null}", groups = AddGroup.class)
    @NotNull(message="{id.require}", groups = UpdateGroup.class)
    private Long id;

    @ApiModelProperty(value = "标题", required = true)
    @NotBlank(message="标题不为空", groups = DefaultGroup.class)
    private String title;

    @ApiModelProperty(value = "内容", required = true)
    @NotBlank(message="内容不为空", groups = DefaultGroup.class)
    private String context;
}
