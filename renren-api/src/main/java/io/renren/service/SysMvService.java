package io.renren.service;
import io.renren.common.service.BaseService;
import io.renren.dto.SysMvDTO;
import io.renren.entity.SysMvEntity;
import java.util.List;


public interface SysMvService extends BaseService<SysMvEntity> {
    List<SysMvDTO> list();

}

