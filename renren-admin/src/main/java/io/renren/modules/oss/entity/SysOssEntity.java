// powered by 天津理工大学心理辅导团队

package io.renren.modules.oss.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件上传
 * 
 * @author Tjut team
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_oss")
public class SysOssEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * URL地址
	 */
	private String url;

}