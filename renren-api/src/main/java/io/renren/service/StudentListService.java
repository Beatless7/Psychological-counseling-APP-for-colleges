package io.renren.service;

import io.renren.common.page.PageData2;
import io.renren.common.service.BaseService;
import io.renren.common.utils.Result;
import io.renren.dto.StudentListDTO;
import io.renren.dto.UserListDTO;

import java.util.List;
import java.util.Map;

public interface StudentListService extends BaseService<StudentListDTO> {
    PageData2<StudentListDTO> list(Map<String, Object> params,Long deptId);

    String studentOrder(Long studentid,Long teacherid);

    StudentListDTO status(Long orderid);
}
