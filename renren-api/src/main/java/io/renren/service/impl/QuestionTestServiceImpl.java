package io.renren.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData2;
import io.renren.common.service.impl.BaseServiceImpl2;
import io.renren.common.utils.ConvertUtils;
import io.renren.dao.QuestionTestDao;
import io.renren.dto.QuestionTestDTO;
import io.renren.entity.QuestionTestEntity;
import io.renren.service.QuestionTestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestionTestServiceImpl extends BaseServiceImpl2<QuestionTestDao, QuestionTestEntity> implements QuestionTestService {

    @Override
    public PageData2<QuestionTestDTO> page(Map<String, Object> params) {
        paramsToLike(params, "username");
        //分页查询
        IPage<QuestionTestEntity> page = getPage(params, Constant.CREATE_DATE, false);
        List<QuestionTestEntity> list = baseDao.getList(params);
        return getPageData(list, page.getTotal(), QuestionTestDTO.class);
    }
    /*
     * 查询所有数据
     */
    @Override
    public List<QuestionTestDTO> list(Map<String, Object> params) {
        List<QuestionTestEntity> entityList = baseDao.getList(params);
        return ConvertUtils.sourceToTarget(entityList, QuestionTestDTO.class);
    }

}
