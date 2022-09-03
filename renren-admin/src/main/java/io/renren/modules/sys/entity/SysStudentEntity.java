// powered by 天津理工大学心理辅导团队

package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 学生
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_student")
public class SysStudentEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 学生姓名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 姓名
	 */
	private String realName;
	/**
	 * 头像
	 */
	private String headUrl;
	/**
	 * 性别   0：男   1：女    2：保密
	 */
	private Integer gender;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 部门ID
	 */
	private Long deptId;
	/**
	 * 心理状态
	 */
	private String psyStates;
	/**
	 * 状态  0：停用   1：正常
	 */
	private Integer status;
	/**
	 * 部门名称
	 */
	@TableField(exist=false)
	private String deptName;
}