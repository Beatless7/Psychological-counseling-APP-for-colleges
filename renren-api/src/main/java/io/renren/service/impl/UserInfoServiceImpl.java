package io.renren.service.impl;

import io.renren.annotation.Login;
import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.utils.ConvertUtils;
import io.renren.dao.UserInfoDao;
import io.renren.dto.StuInfoDTO;
import io.renren.dto.UserInfoDTO;
import io.renren.entity.UserEntity;
import io.renren.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoDao, UserEntity> implements UserInfoService {


    @Override
    public UserInfoDTO getUserInfo(Long id) {
        UserEntity entity = baseDao.getUserInfo(id);
        return ConvertUtils.sourceToTarget(entity, UserInfoDTO.class);
    }

    @Login
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void UpdateUserInfo(Long id, UserInfoDTO dto) {
        baseDao.updateUserInfo(id, dto);
    }
}
