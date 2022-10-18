// powered by 天津理工大学心理辅导团队

package io.renren.dao;

import io.renren.common.dao.BaseDao;
import io.renren.entity.StudentTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Token
 * 
 * @author Tjut team
 */
@Mapper
public interface StudentTokenDao extends BaseDao<StudentTokenEntity> {
    StudentTokenEntity getByToken(String token);

    StudentTokenEntity getByStudentId(Long studentId);
}
