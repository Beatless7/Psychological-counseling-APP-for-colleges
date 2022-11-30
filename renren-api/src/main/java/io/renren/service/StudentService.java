package io.renren.service;

import io.renren.annotation.LoginStudent;
import io.renren.common.service.BaseService;
import io.renren.dto.Student_Score_DTO;
import io.renren.dto.TestResultDTO;
import io.renren.entity.StudentEntity;
import io.renren.dto.LoginDTO;


import java.util.List;
import java.util.Map;

/**
 * 学生
 *
 * @author Tjut team
 */

public interface StudentService extends BaseService<StudentEntity>{

    StudentEntity getByMobile(String mobile);

    StudentEntity getStudentByStudentId(Long StudentId);

    /**
     * 学生登录
     * @param dto    登录表单
     * @return        返回登录信息
     */
    Map<String, Object> login(LoginDTO dto);

    StudentEntity setStudentByPsy(Long id,String psyStates);

    void update(Student_Score_DTO dto);

    List<StudentEntity> getSameDeptStudent(Long deptId);

    void updatePassword(Long id,String newPassword);

    List<TestResultDTO> getTestResultById(Long id);
}
