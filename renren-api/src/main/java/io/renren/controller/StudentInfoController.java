package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginStudent;
import io.renren.common.utils.Result;
import io.renren.common.validator.ValidatorUtils;
import io.renren.dto.PasswordDTO;
import io.renren.dto.StuInfoDTO;
import io.renren.dto.TestResultDTO;
import io.renren.entity.StudentEntity;
import io.renren.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/stu")
@Api(tags = "学生个人信息")
public class StudentInfoController {


    @Autowired
    private StudentService studentService;

    @Login
    @GetMapping("/student/getpassword")
    @ApiOperation("修改密码")
    public Result<String> getPassword(@ApiIgnore @LoginStudent StudentEntity student){
        String password=studentService.getPassword(student.getId());

        return new Result().ok(password);
    }

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
    public Result<StuInfoDTO> getById(@ApiIgnore @LoginStudent StudentEntity student){
        StuInfoDTO data = studentService.getStudentByStudentInfo(student.getId());

        return new Result<StuInfoDTO>().ok(data);
    }


    @Login
    @PutMapping("/student/info")
    @ApiOperation("修改基本信息")
    public Result updateStuInfo(@ApiIgnore @LoginStudent StudentEntity student,@RequestBody StuInfoDTO dto){
        ValidatorUtils.validateEntity(dto);

        studentService.UpdateStuInfo(student.getId(),dto);

        return new Result();
    }
}
