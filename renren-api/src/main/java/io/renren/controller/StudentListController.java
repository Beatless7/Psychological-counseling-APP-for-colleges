package io.renren.controller;


import io.renren.annotation.Login;
import io.renren.annotation.LoginStudent;
import io.renren.common.page.PageData2;
import io.renren.common.utils.Result;
import io.renren.common.validator.ValidatorUtils;
import io.renren.dto.PasswordDTO;
import io.renren.dto.StudentListDTO;
import io.renren.dto.TestResultDTO;
import io.renren.entity.StudentEntity;
import io.renren.service.StudentListService;
import io.renren.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stu")
@Api(tags = "学生列表")
public class StudentListController {

    @Autowired
    private StudentListService studentListService;

    @Autowired
    private StudentService studentService;

    @Login
    @GetMapping("/student/studentInfo")
    @ApiOperation(value = "获取学生信息", response = StudentEntity.class)
    public Result<StudentEntity> studentInfo(@ApiIgnore @LoginStudent StudentEntity student) {
        return new Result<StudentEntity>().ok(student);
    }




    /*@Login
    @GetMapping("/student/page")
    public Result<List<StudentListDTO>> orderlist(@ApiIgnore @LoginStudent StudentEntity student){
        Long deptid=student.getDeptId();
        List<StudentListDTO>orderList=studentListService.list(deptid);
        return new Result<List<StudentListDTO>>().ok(orderList);
    }*/

    @Login
    @GetMapping("/student/page")
    public Result<PageData2<StudentListDTO>> orderlist(@ApiIgnore @RequestParam Map<String, Object> params, @ApiIgnore @LoginStudent StudentEntity student) {
        Long deptid = student.getDeptId();
        PageData2<StudentListDTO> orderList = studentListService.list(params, deptid);
        return new Result<PageData2<StudentListDTO>>().ok(orderList);
    }


    @Login
    @PutMapping("/student/password")
    @ApiOperation("修改密码")
    public Result password(@ApiIgnore @LoginStudent StudentEntity student,@RequestBody PasswordDTO dto){
        ValidatorUtils.validateEntity(dto);

        studentService.updatePassword(student.getId(), dto.getNewPassword());

        return new Result();
    }


    @Login
    @GetMapping("/student/{id}")
    @ApiOperation("测评结果")
    public Result<List<TestResultDTO>> testResult(@PathVariable("id") Long id){
        List<TestResultDTO> data=studentService.getTestResultById(id);

        return new Result<List<TestResultDTO>>().ok(data);
    }
}