/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

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