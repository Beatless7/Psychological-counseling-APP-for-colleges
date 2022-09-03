// powered by 天津理工大学心理辅导团队

package io.renren.modules.sys.service;


import io.renren.common.page.PageData;
import io.renren.common.service.BaseService;
import io.renren.modules.sys.dto.SysRoleDTO;
import io.renren.modules.sys.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;


/**
 * 角色
 * 
 * @author Tjut team
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {

	PageData<SysRoleDTO> page(Map<String, Object> params);

	List<SysRoleDTO> list(Map<String, Object> params);

	SysRoleDTO get(Long id);

	void save(SysRoleDTO dto);

	void update(SysRoleDTO dto);

	void delete(Long[] ids);

}
