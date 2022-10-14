package io.renren.modules.sys.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.sys.entity.SysMvEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysMvDao extends BaseDao<SysMvEntity> {
    List<SysMvEntity> getList(Map<String, Object> params);

    SysMvEntity getById( Long id);
}

