package io.renren.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.renren.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel(value = "文章管理")
public class ArticleDTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @NotNull(message="{id.require}", groups = UpdateGroup.class)
    private Long id;

    @ApiModelProperty(value ="title")
    @NotNull(message="标题不允许为空",groups =UpdateGroup.class)
    private String title;

    @ApiModelProperty(value="context")
    private String context;

    @ApiModelProperty(value = "创建时间")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date createDate;
    @ApiModelProperty(value ="title")
    @NotNull(message="创建者不允许为空",groups =UpdateGroup.class)
    private String creator;
}
