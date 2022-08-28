// powered by 天津理工大学心理辅导团队

package io.renren.modules.security.service;

import io.renren.common.service.BaseService;
import io.renren.common.utils.Result;
import io.renren.modules.security.entity.SysUserTokenEntity;

/**
 * 用户Token
 * 
 * @author Tjut team
 */
public interface SysUserTokenService extends BaseService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	Result createToken(Long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(Long userId);

}