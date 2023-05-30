package io.renren.modules.sys.service;

import io.renren.common.page.PageData;
import io.renren.common.service.BaseService;
import io.renren.modules.sys.dto.SysArticleDTO;
import io.renren.modules.sys.entity.SysArticleEntity;

import java.util.List;
import java.util.Map;

public interface SysArticleService extends BaseService<SysArticleEntity> {
    PageData<SysArticleDTO> page(Map<String, Object> params);

    List<SysArticleDTO> list(Map<String, Object> params);

    SysArticleDTO get(Long id);

    void save(SysArticleDTO dto);

    void update(SysArticleDTO dto);

    void delete(Long[] ids);

}

