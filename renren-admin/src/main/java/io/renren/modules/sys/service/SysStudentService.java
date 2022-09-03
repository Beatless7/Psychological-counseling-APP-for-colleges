// powered by 天津理工大学心理辅导团队

package io.renren.modules.sys.service;

import io.renren.common.page.PageData;
import io.renren.common.service.BaseService;
import io.renren.modules.sys.dto.SysStudentDTO;
import io.renren.modules.sys.dto.SysUserDTO;
import io.renren.modules.sys.entity.SysStudentEntity;

import java.util.List;
import java.util.Map;


/**
 * 学生用户操作
 */
public interface SysStudentService extends BaseService<SysStudentEntity> {

	PageData<SysStudentDTO> page(Map<String, Object> params);

	List<SysStudentDTO> list(Map<String, Object> params);

	SysStudentDTO get(Long id);

	void save(SysStudentDTO dto);

	void update(SysStudentDTO dto);

	void delete(Long[] ids);

}
