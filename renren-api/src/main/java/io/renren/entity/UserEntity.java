// powered by 天津理工大学心理辅导团队

package io.renren.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

/**
 * 教师管理员
 *
 * @author Tjut team
 */

@Data
@TableName("sys_user")
public class UserEntity extends BaseEntity {
	@TableId
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private String realName;

	private String headUrl;

	private Integer gender;

	private String email;

	private String mobile;

	private Long deptId;

	private Integer superAdmin;

	private Integer status;

	private Time orderTime;

	private Integer orderStatus;

	private Long orderStudentId;

	private Time freeTimeBegin;
	
	private Time freeTimeEnd;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date createDate;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Long updater;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateDate;

	@TableField(exist=false)
	private String deptName;

}
