package io.renren.service;

import io.renren.common.service.BaseService;
import io.renren.entity.StudentEntity;
import io.renren.dto.LoginDTO;


import java.util.Map;

/**
 * 学生
 *
 * @author Tjut team
 */

public interface StudentService {

    StudentEntity getByMobile(String mobile);

    StudentEntity getStudentByStudentId(Long StudentId);

    /**
     * 学生登录
     * @param dto    登录表单
     * @return        返回登录信息
     */
    Map<String, Object> login(LoginDTO dto);
}
