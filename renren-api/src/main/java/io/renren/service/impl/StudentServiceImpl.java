package io.renren.service.impl;


import io.renren.annotation.Login;
import io.renren.common.exception.ErrorCode;
import io.renren.common.exception.RenException;
import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.utils.ConvertUtils;
import io.renren.common.validator.AssertUtils;
import io.renren.dao.StudentDao;
import io.renren.dto.*;
import io.renren.entity.QuestionMoreEntity;
import io.renren.entity.StudentEntity;
import io.renren.entity.StudentTokenEntity;
import io.renren.service.StudentService;
import io.renren.service.StudentTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentDao, StudentEntity> implements StudentService {
    @Autowired
    private StudentTokenService tokenService;

    @Override
    public StudentEntity getByMobile(String mobile) {
        return baseDao.getStudentByMobile(mobile);
    }

    @Override
    public StudentEntity getStudentByStudentId(Long StudentId) {
        return baseDao.getStudentByStudentId(StudentId);
    }

    @Override
    public Map<String, Object> login(LoginDTO dto) {
        StudentEntity Student = getByMobile(dto.getMobile());
        AssertUtils.isNull(Student, ErrorCode.ACCOUNT_PASSWORD_ERROR);

        //密码错误
        if(!Student.getPassword().equals(dto.getPassword())){
            throw new RenException(ErrorCode.ACCOUNT_PASSWORD_ERROR);
        }

        //获取登录token
        StudentTokenEntity tokenEntity = tokenService.createToken(Student.getId());

        Map<String, Object> map = new HashMap<>(2);
        map.put("token", tokenEntity.getToken());
        map.put("expire", tokenEntity.getExpireDate().getTime() - System.currentTimeMillis());

        return map;
    }

    @Override
    public StudentEntity setStudentByPsy(Long id,String psyStates) {
        return baseDao.setStudentByPsy(id,psyStates);
    }



    @Override
    public void update(Student_Score_DTO dto) {
        StudentEntity entity = ConvertUtils.sourceToTarget(dto, StudentEntity.class);
        updateById(entity);
    }

    @Login
    @Override
    public List<StudentEntity> getSameDeptStudent(Long deptId) {
        List<StudentEntity> list=baseDao.getSameDeptStudent(deptId);
        return list;
    }

    @Override
    public String getPassword(Long id) {
        return baseDao.getPassword(id);
    }

    @Login
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(Long id, String newPassword) {
        baseDao.updatePassword(id, newPassword);
    }


    @Override
    public List<TestResultDTO> getTestResultById(Long id) {
        List<QuestionMoreEntity> entitys = baseDao.getTestResultById(id);
        return ConvertUtils.sourceToTarget(entitys,TestResultDTO.class);
    }

    @Override
    public StuInfoDTO getStudentByStudentInfo(Long id) {
        StudentEntity entity = baseDao.getStudentInfo(id);
        return ConvertUtils.sourceToTarget(entity,StuInfoDTO.class);
    }

    @Login
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void UpdateStuInfo(Long id,StuInfoDTO dto) {
        baseDao.UpdateStuInfo(id,dto);
    }
}
