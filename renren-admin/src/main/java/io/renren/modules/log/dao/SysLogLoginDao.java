// powered by 天津理工大学心理辅导团队

package io.renren.modules.log.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.log.entity.SysLogLoginEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 登录日志
 *
 * @author Tjut team
 * @since 1.0.0
 */
@Mapper
public interface SysLogLoginDao extends BaseDao<SysLogLoginEntity> {
	
}
