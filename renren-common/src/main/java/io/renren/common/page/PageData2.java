// powered by 天津理工大学心理辅导团队

package io.renren.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 *
 * @author Tjut team
 */
@Data
@ApiModel(value = "分页数据")
public class PageData2<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "总记录数")
    private int total;

    @ApiModelProperty(value = "列表数据")
    private List<T> list;

    /**
     * 分页
     * @param list   列表数据
     * @param total  总记录数
     */
    public PageData2(List<T> list, long total) {
        this.list = list;
        this.total = (int)total;
    }
}