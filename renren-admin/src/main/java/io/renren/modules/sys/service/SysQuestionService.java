package io.renren.modules.sys.service;

import io.renren.common.page.PageData;
import io.renren.common.service.BaseService;
import io.renren.modules.sys.dto.SysQuestionDTO;
import io.renren.modules.sys.entity.SysQuestionEntity;

import java.util.List;
import java.util.Map;

public interface SysQuestionService extends BaseService<SysQuestionEntity> {
    PageData<SysQuestionDTO> page(Map<String, Object> params);

    List<SysQuestionDTO> list(Map<String, Object> params);

    SysQuestionDTO get(Long id);

    void save(SysQuestionDTO dto);

    void update(SysQuestionDTO dto);

    void delete(Long[] ids);
}
