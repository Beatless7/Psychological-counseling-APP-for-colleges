package io.renren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.dto.UserInfoDTO;
import io.renren.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoDao extends BaseMapper<UserEntity> {

    UserEntity getUserInfo(Long id);

    int updateUserInfo(@Param("id") Long id,@Param("dto") UserInfoDTO dto);
}
