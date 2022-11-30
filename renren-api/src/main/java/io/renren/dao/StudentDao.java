package io.renren.dao;

import io.renren.common.dao.BaseDao;
import io.renren.entity.QuestionMoreEntity;
import io.renren.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentDao extends BaseDao<StudentEntity> {
    StudentEntity getStudentByMobile(String mobile);

    StudentEntity getStudentByStudentId(Long userId);

    StudentEntity setStudentByPsy(Long id,String psyStates);

    List<StudentEntity> getSameDeptStudent(Long deptId);

    int updatePassword(@Param("id") Long id, @Param("newPassword") String newPassword);

    List<QuestionMoreEntity> getTestResultById(Long id);
}
