package io.renren.dao;

import io.renren.common.dao.BaseDao;
import io.renren.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentDao extends BaseDao<StudentEntity> {
    StudentEntity getStudentByMobile(String mobile);

    StudentEntity getStudentByStudentId(Long userId);

    StudentEntity setStudentByPsy(Long id,String psyStates);

    List<StudentEntity> getSameDeptStudent(Long deptId);
}
