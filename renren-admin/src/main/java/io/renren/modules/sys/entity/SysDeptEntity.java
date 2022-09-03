// powered by 天津理工大学心理辅导团队

package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.renren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 部门管理
 * 
 * @author Tjut team
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_dept")
public class SysDeptEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * 上级ID
	 */
	private Long pid;
	/**
	 * 所有上级ID，用逗号分开
	 */
	private String pids;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 学校地址
	 */
	private String schoolAddr;
	/**
	 * 学校联系电话
	 */
	private String schoolMobile;
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
	/**
	 * 上级部门名称
	 */
	@TableField(exist = false)
	private String parentName;

}