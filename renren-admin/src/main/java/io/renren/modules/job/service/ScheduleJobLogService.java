// powered by 天津理工大学心理辅导团队

package io.renren.modules.job.service;

import io.renren.common.page.PageData;
import io.renren.common.service.BaseService;
import io.renren.modules.job.dto.ScheduleJobLogDTO;
import io.renren.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author Tjut team
 */
public interface ScheduleJobLogService extends BaseService<ScheduleJobLogEntity> {

	PageData<ScheduleJobLogDTO> page(Map<String, Object> params);

	ScheduleJobLogDTO get(Long id);
}
