package io.renren.service;


import io.renren.common.page.PageData2;
import io.renren.common.service.BaseService;
import io.renren.dto.QuestionTestDTO;
import io.renren.entity.QuestionTestEntity;

import java.util.List;
import java.util.Map;

public interface QuestionTestService extends BaseService<QuestionTestEntity> {
    PageData2<QuestionTestDTO> page(Map<String, Object> params);

    List<QuestionTestDTO> list(Map<String, Object> params);
}
