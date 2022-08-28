// powered by 天津理工大学心理辅导团队

package io.renren.modules.log.service;


import io.renren.common.page.PageData;
import io.renren.common.service.BaseService;
import io.renren.modules.log.dto.SysLogErrorDTO;
import io.renren.modules.log.entity.SysLogErrorEntity;

import java.util.List;
import java.util.Map;

/**
 * 异常日志
 *
 * @author Tjut team
 * @since 1.0.0
 */
public interface SysLogErrorService extends BaseService<SysLogErrorEntity> {

    PageData<SysLogErrorDTO> page(Map<String, Object> params);

    List<SysLogErrorDTO> list(Map<String, Object> params);

    void save(SysLogErrorEntity entity);

}