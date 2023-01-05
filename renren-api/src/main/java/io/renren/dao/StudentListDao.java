package io.renren.dao;

import io.renren.common.dao.BaseDao;
import io.renren.common.page.PageData2;
import io.renren.dto.StudentListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface StudentListDao extends BaseDao<StudentListDTO> {

    List<StudentListDTO> getList(Map<String, Object> params,Long deptId);

    String order(Long studentid,Long teacherid);

    String order1(Long studentid,Long teacherid);

    StudentListDTO orderstatus(Long orderid);

}
