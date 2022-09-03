// powered by 天津理工大学心理辅导团队

package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户Token
 * 
 * @author Tjut team
 */
@Data
@TableName("tb_token")
public class TokenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 用户token
	 */
	private String token;
	/**
	 * 过期时间
	 */
	private Date expireDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;

}