package io.renren.modules.sys.service;

import io.renren.common.page.PageData;
import io.renren.common.service.BaseService;
import io.renren.modules.sys.dto.SysMvDTO;
import io.renren.modules.sys.dto.SysStudentDTO;
import io.renren.modules.sys.entity.SysMvEntity;

import java.util.List;
import java.util.Map;

public interface SysMvService extends BaseService<SysMvEntity> {
    PageData<SysMvDTO> page(Map<String, Object> params);

    List<SysMvDTO> list(Map<String, Object> params);

    SysMvDTO get(Long id);

    void save(SysMvDTO dto);

    void update(SysMvDTO dto);

    void delete(Long[] ids);

}

