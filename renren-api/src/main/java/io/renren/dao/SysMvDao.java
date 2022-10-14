package io.renren.dao;

import io.renren.common.dao.BaseDao;
import io.renren.entity.SysMvEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMvDao extends BaseDao<SysMvEntity> {
    List<SysMvEntity> getList();

    SysMvEntity getById();
}

