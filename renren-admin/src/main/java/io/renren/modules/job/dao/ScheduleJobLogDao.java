// powered by 天津理工大学心理辅导团队

package io.renren.modules.job.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.job.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 *
 * @author Tjut team
 */
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
	
}
