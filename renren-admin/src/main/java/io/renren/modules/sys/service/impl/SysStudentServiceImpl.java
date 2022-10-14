// powered by 天津理工大学心理辅导团队

package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.utils.ConvertUtils;
import io.renren.modules.security.user.SecurityUser;
import io.renren.modules.security.user.UserDetail;
import io.renren.modules.sys.dao.SysStudentDao;
import io.renren.modules.sys.dto.SysStudentDTO;
import io.renren.modules.sys.entity.SysStudentEntity;
import io.renren.modules.sys.enums.SuperAdminEnum;
import io.renren.modules.sys.service.SysDeptService;
import io.renren.modules.sys.service.SysStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 学生
 */
@Service
public class SysStudentServiceImpl extends BaseServiceImpl<SysStudentDao, SysStudentEntity> implements SysStudentService {
	@Autowired
	private SysDeptService sysDeptService;

	@Override
	public PageData<SysStudentDTO> page(Map<String, Object> params) {
		paramsToLike(params, "username");
		//分页查询
		IPage<SysStudentEntity> page = getPage(params, Constant.CREATE_DATE, false);
		//普通管理员，只能查询所属部门及子部门的数据
		UserDetail user = SecurityUser.getUser();
		if(user.getSuperAdmin() == SuperAdminEnum.NO.value()) {
			params.put("deptIdList", sysDeptService.getSubDeptIdList(user.getDeptId()));
		}
		List<SysStudentEntity> list = baseDao.getList(params);
		return getPageData(list, page.getTotal(), SysStudentDTO.class);
	}

	/**
	 * 查询所有数据
	 * @param params
	 * @return
	 */
	@Override
	public List<SysStudentDTO> list(Map<String, Object> params) {
		//普通管理员，只能查询所属部门及子部门的数据
		UserDetail user = SecurityUser.getUser();
		if(user.getSuperAdmin() == SuperAdminEnum.NO.value()) {
			params.put("deptIdList", sysDeptService.getSubDeptIdList(user.getDeptId()));
		}

		List<SysStudentEntity> entityList = baseDao.getList(params);

		return ConvertUtils.sourceToTarget(entityList, SysStudentDTO.class);
	}

	@Override
	public SysStudentDTO get(Long id) {
		SysStudentEntity entity = baseDao.getById(id);

		return ConvertUtils.sourceToTarget(entity, SysStudentDTO.class);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(SysStudentDTO dto) {
		SysStudentEntity entity = ConvertUtils.sourceToTarget(dto, SysStudentEntity.class);
		insert(entity);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(SysStudentDTO dto) {
		SysStudentEntity entity = ConvertUtils.sourceToTarget(dto, SysStudentEntity.class);

		//更新用户
		updateById(entity);

	}

	@Override
	public void delete(Long[] ids) {
		//删除用户
		baseDao.deleteBatchIds(Arrays.asList(ids));
	}



}
