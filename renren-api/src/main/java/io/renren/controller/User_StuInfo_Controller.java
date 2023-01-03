package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.Result;
import io.renren.dto.StuRetDto;
import io.renren.entity.StudentEntity;
import io.renren.entity.UserEntity;
import io.renren.service.StudentService;
import io.renren.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher/user")
@Api(tags = "学生信息")
public class User_StuInfo_Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Login
    @GetMapping("/stu")
    @ApiOperation("获取学生信息")
    public Result<List<StuRetDto>> getAllStu(@ApiIgnore @LoginUser UserEntity user){
        List<StuRetDto> all = userService.getStuAll(user.getId());
        return new Result<List<StuRetDto>>().ok(all);
    }
}
