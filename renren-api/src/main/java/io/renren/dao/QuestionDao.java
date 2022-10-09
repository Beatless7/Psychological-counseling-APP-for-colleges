package io.renren.dao;


import io.renren.common.dao.BaseDao;
import io.renren.entity.QuestionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuestionDao extends BaseDao<QuestionEntity> {

    List<QuestionEntity> getList(Map<String, Object> params);

    QuestionEntity getById(Long id);

}