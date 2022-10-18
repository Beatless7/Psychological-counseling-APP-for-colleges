package io.renren.service;
import io.renren.common.service.BaseService;
import io.renren.dto.ArticleDTO;
import io.renren.entity.ArticleEntity;
import java.util.List;
public interface ArticleService extends BaseService<ArticleEntity>{
    List<ArticleDTO> list();

}
