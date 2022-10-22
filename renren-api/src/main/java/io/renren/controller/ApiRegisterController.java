// powered by 天津理工大学心理辅导团队

package io.renren.controller;

import io.renren.common.utils.Result;
import io.renren.common.validator.ValidatorUtils;
import io.renren.dto.StudentRegisterDTO;
import io.renren.entity.StudentEntity;
import io.renren.entity.UserEntity;
import io.renren.dto.RegisterDTO;
import io.renren.service.StudentService;
import io.renren.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 注册接口
 *
 * @author Tjut team
 */
@RestController
@RequestMapping("/api")
@Api(tags="注册接口")
public class ApiRegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    StudentService studentService;

    @PostMapping("register")
    @ApiOperation("注册")
    public Result register(@RequestBody RegisterDTO dto){
        //表单校验
        ValidatorUtils.validateEntity(dto);

        UserEntity user = new UserEntity();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setRealName(dto.getRealName());
        user.setHeadUrl(dto.getHeadUrl());
        user.setGender(dto.getGender());
        user.setEmail(dto.getEmail());
        user.setMobile(dto.getMobile());
        user.setSuperAdmin(dto.getSuperAdmin());
        user.setPassword(dto.getPassword());
        user.setDeptId(dto.getDeptId());
        user.setCreateDate(new Date());
        user.setFreeTimeBegin(dto.getFreeTimeBegin());
        user.setFreeTimeEnd(dto.getFreeTimeEnd());
        userService.insert(user);

        return new Result();
    }

    @PostMapping("StudentRegister")
    @ApiOperation("学生注册")
    public Result registerStudent(@RequestBody StudentRegisterDTO dto){
        ValidatorUtils.validateEntity(dto);

        StudentEntity student = new StudentEntity();
        student.setId(dto.getId());
        student.setUsername(dto.getUsername());
        student.setRealName(dto.getRealName());
        student.setHeadUrl(dto.getHeadUrl());
        student.setGender(dto.getGender());
        student.setEmail(dto.getEmail());
        student.setMobile(dto.getMobile());
        student.setPassword(dto.getPassword());
        student.setDeptId(dto.getDeptId());
        studentService.insert(student);

        return new Result();
    }

}