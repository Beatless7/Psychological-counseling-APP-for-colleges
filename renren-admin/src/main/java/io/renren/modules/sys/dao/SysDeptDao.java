// powered by 天津理工大学心理辅导团队

package io.renren.modules.sys.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.sys.entity.SysDeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author Tjut team
 */
@Mapper
public interface SysDeptDao extends BaseDao<SysDeptEntity> {

    List<SysDeptEntity> getList(Map<String, Object> params);

    SysDeptEntity getById(Long id);

    /**
     * 获取所有部门的id、pid列表
     */
    List<SysDeptEntity> getIdAndPidList();

    /**
     * 根据部门ID，获取所有子部门ID列表
     * @param id   部门ID
     */
    List<Long> getSubDeptIdList(String id);

}