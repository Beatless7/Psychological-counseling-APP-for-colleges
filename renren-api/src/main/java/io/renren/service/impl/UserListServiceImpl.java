package io.renren.service.impl;

import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.utils.ConvertUtils;
import io.renren.dao.UserListDao;
import io.renren.dto.UserListDTO;
import io.renren.entity.UserEntity;
import io.renren.service.UserListService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserListServiceImpl extends BaseServiceImpl<UserListDao, UserEntity> implements UserListService {
    @Override
    public List<UserListDTO> list() {
        List<UserEntity> entityList = baseDao.getList();
        return ConvertUtils.sourceToTarget(entityList, UserListDTO.class);
    }

    @Override
    public UserEntity setUserPsy(Long id, Integer orderStatus) {
        return baseDao.setUserPsy(id,orderStatus);
    }
}
