package io.renren.dao;


import io.renren.common.dao.BaseDao;
import io.renren.entity.QuestionTestEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuestionTestDao extends BaseDao<QuestionTestEntity> {

    List<QuestionTestEntity> getList(Map<String, Object> params);

    List<QuestionTestEntity> getList();

    QuestionTestEntity getById(Long id);

}