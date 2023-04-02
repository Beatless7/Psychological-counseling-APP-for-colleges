package io.renren.dao;

import io.renren.common.dao.BaseDao;
import io.renren.common.page.PageData2;
import io.renren.entity.MicroExpressionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MicroExpressionDao extends BaseDao<MicroExpressionEntity> {
    List<MicroExpressionEntity> getResult();
}
