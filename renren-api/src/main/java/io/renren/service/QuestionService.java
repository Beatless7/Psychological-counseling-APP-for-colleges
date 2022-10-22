package io.renren.service;


import io.renren.common.page.PageData2;
import io.renren.common.service.BaseService;
import io.renren.dto.QuestionDTO;
import io.renren.entity.QuestionEntity;

import java.util.List;
import java.util.Map;

public interface QuestionService extends BaseService<QuestionEntity> {
    PageData2<QuestionDTO> page(Map<String, Object> params);

    List<QuestionDTO> list(Map<String, Object> params);
}
