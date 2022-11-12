package io.renren.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.common.dao.BaseDao;
import io.renren.entity.ArticleEntity;
import io.renren.entity.QuestionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuestionDao extends BaseDao<QuestionEntity>, BaseMapper<QuestionEntity> {
    List<QuestionEntity> getList();
}