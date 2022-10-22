package io.renren.service;
import io.renren.common.page.PageData;
import io.renren.common.page.PageData2;
import io.renren.common.service.BaseService;
import io.renren.dto.SysMvDTO;
import io.renren.entity.SysMvEntity;
import java.util.List;
import java.util.Map;


public interface SysMvService extends BaseService<SysMvEntity> {
    List<SysMvDTO> list(Map<String, Object> params);
    PageData2<SysMvDTO> page(Map<String, Object> params);
}

