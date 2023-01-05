package io.renren.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData2;
import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.service.impl.BaseServiceImpl2;
import io.renren.common.utils.ConvertUtils;
import io.renren.common.utils.Result;
import io.renren.dao.StudentListDao;
import io.renren.dto.StudentListDTO;
import io.renren.service.StudentListService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class StudentListServiceImpl extends BaseServiceImpl2<StudentListDao,StudentListDTO> implements StudentListService {
    @Override
    public PageData2<StudentListDTO> list(Map<String, Object> params,Long deptId) {
        paramsToLike(params, "username");
        List<StudentListDTO> list=baseDao.getList(params,deptId);

        IPage<StudentListDTO> page = getPage(params, Constant.CREATE_DATE, false);
        //return ConvertUtils.sourceToTarget(list,StudentListDTO.class);
        return getPageData(list, list.size(), StudentListDTO.class);

    }

    @Override
    public String studentOrder(Long studentid, Long teacherid) {
        String studentorder=baseDao.order(studentid,teacherid);
        String teacherorder=baseDao.order1(studentid,teacherid);
        return "";

    }

    @Override
    public StudentListDTO status(Long orderid) {
        StudentListDTO a=baseDao.orderstatus(orderid);
        return a;
    }
}
