package io.renren.modules.sys.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.sys.entity.SysQuestionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface SysQuestionDao extends BaseDao<SysQuestionEntity> {

    List<SysQuestionEntity> getList(Map<String, Object> params);

    SysQuestionEntity getById(Long id);

}