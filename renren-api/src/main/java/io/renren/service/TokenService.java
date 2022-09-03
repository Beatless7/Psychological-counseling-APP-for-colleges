// powered by 天津理工大学心理辅导团队

package io.renren.service;

import io.renren.common.service.BaseService;
import io.renren.entity.TokenEntity;

/**
 * 用户Token
 * 
 * @author Tjut team
 */
public interface TokenService extends BaseService<TokenEntity> {

	TokenEntity getByToken(String token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 * @return        返回token信息
	 */
	TokenEntity createToken(Long userId);

	/**
	 * 设置token过期
	 * @param userId 用户ID
	 */
	void expireToken(Long userId);

}
