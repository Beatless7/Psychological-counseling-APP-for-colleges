// powered by 天津理工大学心理辅导团队

package io.renren.modules.sys.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.sys.entity.SysStudentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 学生
 */
@Mapper
public interface SysStudentDao extends BaseDao<SysStudentEntity> {

    List<SysStudentEntity> getList(Map<String, Object> params);

    SysStudentEntity getById(Long id);
}