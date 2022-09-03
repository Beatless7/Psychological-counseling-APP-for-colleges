package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.page.PageData;
import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.utils.ConvertUtils;
import io.renren.modules.sys.dao.SysQuestionDao;
import io.renren.modules.sys.dto.SysQuestionDTO;
import io.renren.modules.sys.entity.SysQuestionEntity;
import io.renren.modules.sys.service.SysQuestionService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class SysQuestionServiceImpl extends BaseServiceImpl<SysQuestionDao, SysQuestionEntity> implements SysQuestionService {

    @Override
    public PageData<SysQuestionDTO> page(Map<String, Object> params) {
        paramsToLike(params, "id");

        //分页
        IPage<SysQuestionEntity> page = getPage(params, String.valueOf(1), false);

        //查询
        List<SysQuestionEntity> list = baseDao.getList(params);

        return getPageData(list, page.getTotal(), SysQuestionDTO.class);
    }

    @Override
    public List<SysQuestionDTO> list(Map<String, Object> params) {
        List<SysQuestionEntity> entityList = baseDao.getList(params);

        return ConvertUtils.sourceToTarget(entityList, SysQuestionDTO.class);
    }

    @Override
    public SysQuestionDTO get(Long id) {
        SysQuestionEntity entity = baseDao.getById(id);

        return ConvertUtils.sourceToTarget(entity, SysQuestionDTO.class);
    }

    @Override
    public void save(SysQuestionDTO dto) {
        SysQuestionEntity entity = ConvertUtils.sourceToTarget(dto, SysQuestionEntity.class);
        insert(entity);
    }

    @Override
    public void update(SysQuestionDTO dto) {
        SysQuestionEntity entity = ConvertUtils.sourceToTarget(dto, SysQuestionEntity.class);
        updateById(entity);
    }

    @Override
    public void delete(Long[] ids) {
        baseDao.deleteBatchIds(Arrays.asList(ids));
    }
}
