package io.renren.service;


import io.renren.common.page.PageData;
import io.renren.common.service.BaseService;
import io.renren.dto.ArticleDTO;
import io.renren.dto.QuestionDTO;
import io.renren.entity.QuestionEntity;

import java.util.List;
import java.util.Map;

public interface QuestionService extends BaseService<QuestionEntity> {

    QuestionDTO get(Long id);

    void update(QuestionDTO dto);

    void save(QuestionDTO dto);

    List<QuestionDTO> list();
}
