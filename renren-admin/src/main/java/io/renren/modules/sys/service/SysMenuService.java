// powered by 天津理工大学心理辅导团队

package io.renren.modules.sys.service;

import io.renren.common.service.BaseService;
import io.renren.modules.security.user.UserDetail;
import io.renren.modules.sys.dto.SysMenuDTO;
import io.renren.modules.sys.entity.SysMenuEntity;

import java.util.List;


/**
 * 菜单管理
 * 
 * @author Tjut team
 */
public interface SysMenuService extends BaseService<SysMenuEntity> {

	SysMenuDTO get(Long id);

	void save(SysMenuDTO dto);

	void update(SysMenuDTO dto);

	void delete(Long id);

	/**
	 * 菜单列表
	 *
	 * @param type 菜单类型
	 */
	List<SysMenuDTO> getAllMenuList(Integer type);

	/**
	 * 用户菜单列表
	 *
	 * @param user  用户
	 * @param type 菜单类型
	 */
	List<SysMenuDTO> getUserMenuList(UserDetail user, Integer type);

	/**
	 * 根据父菜单，查询子菜单
	 * @param pid  父菜单ID
	 */
	List<SysMenuDTO> getListPid(Long pid);
}
