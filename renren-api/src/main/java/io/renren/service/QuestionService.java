package io.renren.service;


import io.renren.common.service.BaseService;
import io.renren.dto.QuestionDTO;
import io.renren.entity.QuestionEntity;

public interface QuestionService extends BaseService<QuestionEntity> {
    QuestionDTO get(Long id);

    void update(QuestionDTO dto);

    void save(QuestionDTO dto);

}
