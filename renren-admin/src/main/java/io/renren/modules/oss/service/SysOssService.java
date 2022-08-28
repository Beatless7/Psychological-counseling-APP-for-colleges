// powered by 天津理工大学心理辅导团队

package io.renren.modules.oss.service;

import io.renren.common.page.PageData;
import io.renren.common.service.BaseService;
import io.renren.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 * 
 * @author Tjut team
 */
public interface SysOssService extends BaseService<SysOssEntity> {

	PageData<SysOssEntity> page(Map<String, Object> params);
}
