package io.renren.service.impl;


import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.utils.ConvertUtils;
import io.renren.dao.QuestionDao;
import io.renren.dto.QuestionDTO;
import io.renren.entity.QuestionEntity;
import io.renren.service.QuestionService;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl extends BaseServiceImpl<QuestionDao, QuestionEntity> implements QuestionService {

    @Override
    public QuestionDTO get(Long id) {
        QuestionEntity entity = baseDao.getById(id);
        return ConvertUtils.sourceToTarget(entity, QuestionDTO.class);
    }

    @Override
    public void update(QuestionDTO dto) {
        QuestionEntity entity = ConvertUtils.sourceToTarget(dto, QuestionEntity.class);
        updateById(entity);
    }
    @Override
    public void save(QuestionDTO dto) {
        QuestionEntity entity = ConvertUtils.sourceToTarget(dto, QuestionEntity.class);
        insert(entity);
    }

}
