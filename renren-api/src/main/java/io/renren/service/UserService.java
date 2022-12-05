// powered by 天津理工大学心理辅导团队

package io.renren.service;

import io.renren.common.service.BaseService;
import io.renren.dto.UserStuDTO;
import io.renren.entity.UserEntity;
import io.renren.dto.LoginDTO;

import java.util.Map;

/**
 * 教师管理员
 * 
 * @author Tjut team
 */
public interface UserService extends BaseService<UserEntity> {

	UserEntity getByMobile(String mobile);

	UserEntity getUserByUserId(Long userId);

	/**
	 * 教师管理员登录
	 * @param dto    登录表单
	 * @return        返回登录信息
	 */
	Map<String, Object> login(LoginDTO dto);

	UserStuDTO getStuById(Long id);
}
