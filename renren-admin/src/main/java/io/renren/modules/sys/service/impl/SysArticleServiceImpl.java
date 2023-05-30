package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.utils.ConvertUtils;
import io.renren.modules.sys.dao.SysArticleDao;
import io.renren.modules.sys.dto.SysArticleDTO;
import io.renren.modules.sys.entity.SysArticleEntity;
import io.renren.modules.sys.service.SysArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class SysArticleServiceImpl extends BaseServiceImpl<SysArticleDao, SysArticleEntity> implements SysArticleService {
    @Override
    public PageData<SysArticleDTO> page(Map<String, Object> params) {
        paramsToLike(params, "username");
        //分页查询
        IPage<SysArticleEntity> page = getPage(params, Constant.CREATE_DATE, false);
        List<SysArticleEntity> list = baseDao.getList(params);
        return getPageData(list, page.getTotal(), SysArticleDTO.class);
    }
    /**
     * 查询所有数据
     */
    @Override
    public List<SysArticleDTO> list(Map<String, Object> params) {
        List<SysArticleEntity> entityList = baseDao.getList(params);
        return ConvertUtils.sourceToTarget(entityList, SysArticleDTO.class);
    }
    @Override
    public SysArticleDTO get(Long id) {
        SysArticleEntity entity = baseDao.getById(id);

        return ConvertUtils.sourceToTarget(entity, SysArticleDTO.class);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysArticleDTO dto) {
        SysArticleEntity entity = ConvertUtils.sourceToTarget(dto, SysArticleEntity.class);
        insert(entity);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysArticleDTO dto) {
        SysArticleEntity entity = ConvertUtils.sourceToTarget(dto, SysArticleEntity.class);

        //更新用户
        updateById(entity);

    }

    @Override
    public void delete(Long[] ids) {
        //删除用户
        baseDao.deleteBatchIds(Arrays.asList(ids));
    }
}
