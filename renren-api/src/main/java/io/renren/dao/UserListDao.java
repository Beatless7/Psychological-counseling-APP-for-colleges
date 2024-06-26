package io.renren.dao;

import io.renren.common.dao.BaseDao;
import io.renren.entity.StudentEntity;
import io.renren.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Mapper
public interface UserListDao extends BaseDao<UserEntity> {
    List<UserEntity> getList();

    UserEntity getById(Long id);

    UserEntity setUserPsy(Long id,Integer orderStatus);

    List<StudentEntity> getAll(Long id);

    String order2(Long studentid);

    String order3(Long teacherid);
}
