package io.renren.service.impl;

import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.utils.ConvertUtils;
import io.renren.dao.ArticleDao;

import io.renren.dto.ArticleDTO;
import io.renren.entity.ArticleEntity;
import io.renren.service.ArticleService;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ArticleServiceImpl extends BaseServiceImpl<ArticleDao, ArticleEntity> implements ArticleService {
    /*
     * 查询所有数据
     */
    @Override
    public List<ArticleDTO> list() {
        List<ArticleEntity> entityList = baseDao.getList();
        return ConvertUtils.sourceToTarget(entityList, ArticleDTO.class);
    }
}
