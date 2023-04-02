package io.renren.service.impl;

import io.renren.common.page.PageData2;
import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.dao.MicroExpressionDao;
import io.renren.entity.MicroExpressionEntity;
import io.renren.service.MicroExpressionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MicroExpressionServiceImpl extends BaseServiceImpl<MicroExpressionDao,MicroExpressionEntity> implements MicroExpressionService {

    @Override
    public List<MicroExpressionEntity> showExpressionResult() {
        List<MicroExpressionEntity> result=baseDao.getResult();
        return result;
    }
}
