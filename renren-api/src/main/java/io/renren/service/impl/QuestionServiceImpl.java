package io.renren.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData2;
import io.renren.common.service.impl.BaseServiceImpl2;
import io.renren.common.utils.ConvertUtils;
import io.renren.dao.QuestionDao;
import io.renren.dto.QuestionDTO;
import io.renren.entity.QuestionEntity;
import io.renren.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl extends BaseServiceImpl2<QuestionDao, QuestionEntity> implements QuestionService {

    @Override
    public PageData2<QuestionDTO> page(Map<String, Object> params) {
        paramsToLike(params, "username");
        //分页查询
        IPage<QuestionEntity> page = getPage(params, Constant.CREATE_DATE, false);
        List<QuestionEntity> list = baseDao.getList(params);
        return getPageData(list, page.getTotal(), QuestionDTO.class);
    }
    /*
     * 查询所有数据
     */
    @Override
    public List<QuestionDTO> list(Map<String, Object> params) {
        List<QuestionEntity> entityList = baseDao.getList(params);
        return ConvertUtils.sourceToTarget(entityList, QuestionDTO.class);
    }

}
