package io.renren.modules.sys.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.sys.entity.SysArticleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysArticleDao extends BaseDao<SysArticleEntity> {
    List<SysArticleEntity> getList(Map<String, Object> params);

    SysArticleEntity getById( Long id);
}

