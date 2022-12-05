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
    @GetMapping("/student/testResult/{id}")
    @ApiOperation("测评结果")
    public Result<List<TestResultDTO>> testResult(@PathVariable("id") Long id){
        List<TestResultDTO> data=studentService.getTestResultById(id);

        return new Result<List<TestResultDTO>>().ok(data);
    }


    @Login
    @GetMapping("/student/{id}")
    @ApiOperation("基本信息")
    public Result<StudentEntity> getById(@PathVariable Long id){
        StudentEntity data = studentService.getStudentByStudentId(id);

        return new Result<StudentEntity>().ok(data);
    }


}
