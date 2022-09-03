// powered by 天津理工大学心理辅导团队

package io.renren.dao;

import io.renren.common.dao.BaseDao;
import io.renren.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * 
 * @author Tjut team
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {
    UserEntity getUserByMobile(String mobile);

    UserEntity getUserByUserId(Long userId);
}
