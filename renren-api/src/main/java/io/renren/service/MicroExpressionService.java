package io.renren.service;

import io.renren.common.page.PageData2;
import io.renren.common.service.BaseService;
import io.renren.common.utils.Result;
import io.renren.entity.MicroExpressionEntity;

import java.util.List;

public interface MicroExpressionService extends BaseService<MicroExpressionEntity> {

    List<MicroExpressionEntity> showExpressionResult();
}
