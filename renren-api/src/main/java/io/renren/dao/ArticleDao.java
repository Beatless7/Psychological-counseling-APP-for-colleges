package io.renren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.common.dao.BaseDao;
import io.renren.entity.ArticleEntity;
import io.renren.entity.SysMvEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDao extends BaseDao<ArticleEntity>, BaseMapper<ArticleEntity> {
    List<ArticleEntity> getList();
}