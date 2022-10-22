package io.renren.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.page.PageData2;
import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.service.impl.BaseServiceImpl2;
import io.renren.common.utils.ConvertUtils;
import io.renren.dao.SysMvDao;
import io.renren.dto.SysMvDTO;
import io.renren.entity.SysMvEntity;
import io.renren.service.SysMvService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class SysMvServiceImpl extends BaseServiceImpl2<SysMvDao, SysMvEntity> implements SysMvService {
    @Override
    public PageData2<SysMvDTO> page(Map<String, Object> params) {
        paramsToLike(params, "username");
        //分页查询
        IPage<SysMvEntity> page = getPage(params, Constant.CREATE_DATE, false);
        List<SysMvEntity> list = baseDao.getList(params);
        return getPageData(list, page.getTotal(), SysMvDTO.class);
    }
    /*
     * 查询所有数据
     */
    @Override
    public List<SysMvDTO> list(Map<String, Object> params) {
        List<SysMvEntity> entityList = baseDao.getList(params);
        return ConvertUtils.sourceToTarget(entityList, SysMvDTO.class);
    }
}
