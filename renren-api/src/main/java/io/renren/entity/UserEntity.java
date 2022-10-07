// powered by 天津理工大学心理辅导团队

package io.renren.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 教师管理员
 *
 * @author Tjut team
 */

@Data
@TableName("sys_user")
public class UserEntity implements Serializable {
	@TableId
	private  long id = 1L;

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

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date createDate;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Long updater;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateDate;

	@TableField(exist=false)
	private String deptName;

}
// powered by 天津理工大学心理辅导团队
/*

package io.renren.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

*/
/**
 * 用户
 *
 * @author Tjut team
 *//*

@Data
@TableName("tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	*/
/**
 * 用户ID
 *//*

	@TableId
	private Long id;
	*/
/**
 * 用户名
 *//*

	private String username;
	*/
/**
 * 手机号
 *//*

	private String mobile;
	*/
/**
 * 密码
 *//*

	@JSONField(serialize=false)
	private String password;
	*/
/**
 * 创建时间
 *//*

	private Date createDate;

}*/
