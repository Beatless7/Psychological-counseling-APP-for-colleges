package io.renren.service.impl;
import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.utils.ConvertUtils;
import io.renren.dao.SysMvDao;
import io.renren.dto.SysMvDTO;
import io.renren.entity.SysMvEntity;
import io.renren.service.SysMvService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class SysMvServiceImpl extends BaseServiceImpl<SysMvDao, SysMvEntity> implements SysMvService {
    /*
     * 查询所有数据
     */
    @Override
    public List<SysMvDTO> list() {
        List<SysMvEntity> entityList = baseDao.getList();
        return ConvertUtils.sourceToTarget(entityList, SysMvDTO.class);
    }
}
