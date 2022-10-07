package io.renren.dao;

import io.renren.common.dao.BaseDao;
import io.renren.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao extends BaseDao<StudentEntity> {
    StudentEntity getStudentByMobile(String mobile);

    StudentEntity getStudentByStudentId(Long userId);
}
