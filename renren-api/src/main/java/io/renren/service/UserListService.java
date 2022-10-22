package io.renren.service;

import io.renren.common.service.BaseService;
import io.renren.dto.UserListDTO;
import io.renren.entity.UserEntity;

import java.util.List;

public interface UserListService extends BaseService<UserEntity> {
    List<UserListDTO> list();

    UserEntity setUserPsy(Long id, Integer orderStatus);
}
