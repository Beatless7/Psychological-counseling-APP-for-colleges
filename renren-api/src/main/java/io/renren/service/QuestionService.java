package io.renren.service;

import io.renren.common.service.BaseService;
import io.renren.dto.QuestionDTO;
import io.renren.entity.QuestionEntity;

import java.util.List;

public interface QuestionService extends BaseService<QuestionEntity>{
    List<QuestionDTO> list();

}
