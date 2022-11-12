package io.renren.service.impl;

import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.utils.ConvertUtils;
import io.renren.dao.QuestionDao;
import io.renren.dto.QuestionDTO;
import io.renren.entity.QuestionEntity;
import io.renren.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl extends BaseServiceImpl<QuestionDao, QuestionEntity> implements QuestionService {
    /*
     * 查询所有数据
     */
    @Override
    public List<QuestionDTO> list() {
        List<QuestionEntity> entityList = baseDao.getList();
        return ConvertUtils.sourceToTarget(entityList, QuestionDTO.class);
    }
}
