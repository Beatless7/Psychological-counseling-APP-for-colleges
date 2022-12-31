package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginStudent;
import io.renren.common.utils.Result;
import io.renren.common.validator.ValidatorUtils;
import io.renren.dto.PasswordDTO;
import io.renren.dto.TestResultDTO;
import io.renren.entity.StudentEntity;
import io.renren.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/stu")
@Api(tags = "学生个人信息")
public class StudentInfoController {


    @Autowired
    private StudentService studentService;

    @Login
    @PutMapping("/student/password")
    @ApiOperation("修改密码")
    public Result password(@ApiIgnore @LoginStudent StudentEntity student, @RequestBody PasswordDTO dto){
        ValidatorUtils.validateEntity(dto);

        studentService.updatePassword(student.getId(), dto.getNewPassword());

        return new Result();
    }



    @Login
    @GetMapping("/student/testResult")
    @ApiOperation("测评结果")
    public Result<List<TestResultDTO>> testResult(@ApiIgnore @LoginStudent StudentEntity student){
        List<TestResultDTO> data=studentService.getTestResultById(student.getId());

        return new Result<List<TestResultDTO>>().ok(data);
    }


    @Login
    @GetMapping("/student")
    @ApiOperation("基本信息")
    public Result<StudentEntity> getById(@ApiIgnore @LoginStudent StudentEntity student){
        StudentEntity data = studentService.getStudentByStudentId(student.getId());

        return new Result<StudentEntity>().ok(data);
    }


}
