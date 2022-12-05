package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.common.utils.Result;
import io.renren.dto.UserStuDTO;
import io.renren.dto.TestResultDTO;
import io.renren.service.StudentService;
import io.renren.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher/user")
@Api(tags = "学生信息")
public class User_StuInfo_Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;



    @Login
    @GetMapping("stu/{id}")
    @ApiOperation("获取学生信息")
    public Result<UserStuDTO> getStudent(@PathVariable("id") Long id){
        UserStuDTO data = userService.getStuById(id);
        return new Result<UserStuDTO>().ok(data);
    }



    @Login
    @GetMapping("stu/result/{id}")
    @ApiOperation("获取学生信息")
    public Result<List<TestResultDTO>> getStudentResult(@PathVariable("id") Long id){
        List<TestResultDTO> data = studentService.getTestResultById(id);
        return new Result<List<TestResultDTO>>().ok(data);
    }
}
