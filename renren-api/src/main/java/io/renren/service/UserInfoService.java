package io.renren.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.common.service.BaseService;
import io.renren.dto.UserInfoDTO;
import io.renren.entity.UserEntity;

public interface UserInfoService extends BaseService<UserEntity> {

    UserInfoDTO getUserInfo(Long id);

    void UpdateUserInfo(Long id, UserInfoDTO dto);
}
