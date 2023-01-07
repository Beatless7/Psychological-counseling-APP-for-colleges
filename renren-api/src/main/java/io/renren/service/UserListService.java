package io.renren.service;

import io.renren.common.service.BaseService;
import io.renren.dto.StuRetDto;
import io.renren.dto.StudentDTO;
import io.renren.dto.UserListDTO;
import io.renren.entity.UserEntity;
import io.renren.dto.StudentListDTO;
import io.renren.common.utils.Result;
import java.util.List;

public interface UserListService extends BaseService<UserEntity> {
    List<UserListDTO> list();

    UserEntity setUserPsy(Long id, Integer orderStatus);

   List<StudentDTO> getAll(Long id);

    String teacherOrder(Long studentid);

    String teacherOrder1(Long teacherid);
}
