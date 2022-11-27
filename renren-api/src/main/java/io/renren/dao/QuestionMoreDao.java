package io.renren.dao;

import io.renren.common.dao.BaseDao;
import io.renren.entity.QuestionMoreEntity;
import org.apache.ibatis.annotations.Mapper;
import org.joda.time.DateTime;

@Mapper
public interface QuestionMoreDao extends BaseDao<QuestionMoreEntity> {

//    QuestionMoreEntity setByPsy(Long id, String name, String psyStates, DateTime workTime);

}
