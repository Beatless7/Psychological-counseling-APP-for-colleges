// powered by 天津理工大学心理辅导团队

package io.renren.modules.job.service;

import io.renren.common.page.PageData;
import io.renren.common.service.BaseService;
import io.renren.modules.job.dto.ScheduleJobDTO;
import io.renren.modules.job.entity.ScheduleJobEntity;

import java.util.Map;

/**
 * 定时任务
 *
 * @author Tjut team
 */
public interface ScheduleJobService extends BaseService<ScheduleJobEntity> {

	PageData<ScheduleJobDTO> page(Map<String, Object> params);

	ScheduleJobDTO get(Long id);

	/**
	 * 保存定时任务
	 */
	void save(ScheduleJobDTO dto);
	
	/**
	 * 更新定时任务
	 */
	void update(ScheduleJobDTO dto);
	
	/**
	 * 批量删除定时任务
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 批量更新定时任务状态
	 */
	int updateBatch(Long[] ids, int status);
	
	/**
	 * 立即执行
	 */
	void run(Long[] ids);
	
	/**
	 * 暂停运行
	 */
	void pause(Long[] ids);
	
	/**
	 * 恢复运行
	 */
	void resume(Long[] ids);
}
