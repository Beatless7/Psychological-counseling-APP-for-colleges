package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.utils.ConvertUtils;
import io.renren.modules.sys.dao.SysMvDao;
import io.renren.modules.sys.dto.SysMvDTO;
import io.renren.modules.sys.entity.SysMvEntity;
import io.renren.modules.sys.service.SysMvService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class SysMvServiceImpl extends BaseServiceImpl<SysMvDao, SysMvEntity> implements SysMvService {
    @Override
    public PageData<SysMvDTO> page(Map<String, Object> params) {
        paramsToLike(params, "username");
        //分页查询
        IPage<SysMvEntity> page = getPage(params, Constant.CREATE_DATE, false);
        List<SysMvEntity> list = baseDao.getList(params);
        return getPageData(list, page.getTotal(), SysMvDTO.class);
    }
    /**
     * 查询所有数据
     */
    @Override
    public List<SysMvDTO> list(Map<String, Object> params) {
        List<SysMvEntity> entityList = baseDao.getList(params);
        return ConvertUtils.sourceToTarget(entityList, SysMvDTO.class);
    }
    @Override
    public SysMvDTO get(Long id) {
        SysMvEntity entity = baseDao.getById(id);

        return ConvertUtils.sourceToTarget(entity, SysMvDTO.class);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysMvDTO dto) {
        SysMvEntity entity = ConvertUtils.sourceToTarget(dto, SysMvEntity.class);
        insert(entity);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysMvDTO dto) {
        SysMvEntity entity = ConvertUtils.sourceToTarget(dto, SysMvEntity.class);

        //更新用户
        updateById(entity);

    }

    @Override
    public void delete(Long[] ids) {
        //删除用户
        baseDao.deleteBatchIds(Arrays.asList(ids));
    }
}
