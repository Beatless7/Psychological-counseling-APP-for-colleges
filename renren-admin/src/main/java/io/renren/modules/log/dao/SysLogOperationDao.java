// powered by 天津理工大学心理辅导团队

package io.renren.modules.log.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.log.entity.SysLogOperationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 操作日志
 *
 * @author Tjut team
 * @since 1.0.0
 */
@Mapper
public interface SysLogOperationDao extends BaseDao<SysLogOperationEntity> {
	
}
