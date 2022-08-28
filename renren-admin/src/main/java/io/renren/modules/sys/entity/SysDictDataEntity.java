// powered by 天津理工大学心理辅导团队

package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 数据字典
 *
 * @author Tjut team
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_dict_data")
public class SysDictDataEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 字典类型ID
	 */
	private Long dictTypeId;
	/**
	 * 字典标签
	 */
	private String dictLabel;
	/**
	 * 字典值
	 */
	private String dictValue;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 更新者
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Long updater;
	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateDate;
}