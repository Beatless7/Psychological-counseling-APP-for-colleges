package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.Result;
import io.renren.dto.StudentDTO;
import io.renren.dto.TestResultDTO;
import io.renren.dto.UserListDTO;
import io.renren.entity.UserEntity;
import io.renren.service.StudentService;
import io.renren.service.UserListService;
import io.renren.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Api(tags = "教师管理")
public class UserListController {
    @Autowired
    private UserListService userListService;

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    //获取教师列表（当前登录教师的信息）
    @Login
    @GetMapping("user/userInfo")
    @ApiOperation(value="获取教师管理员信息", response= UserEntity.class)
    public Result<UserEntity> userInfo(@ApiIgnore @LoginUser UserEntity user){
        return new Result<UserEntity>().ok(user);
    }

    @Login
    @PostMapping("user/OrderStatus")
    @ApiOperation("获取用户ID")
    public Result getUserPsy(@ApiIgnore @RequestAttribute("userId") Long userId,@RequestBody UserListDTO dto){
        Integer number = dto.getOrderStatus();
        if(number == 0){
            number = 1;
        }else{
            number = 0;
        }
        userListService.setUserPsy(userId,number);
        return new Result();
    }

//
//    @GetMapping("page")
//    @RequiresPermissions("sys:user:info")
//    public Result<List<UserListDTO>> list() {
//        List<UserListDTO> data = userListService.list();
//        return new Result<List<UserListDTO>>().ok(data);
//    }


    @Login
    @GetMapping("stu/{id}")
    @ApiOperation("获取学生信息")
    public Result<StudentDTO> getStudent(@PathVariable("id") Long id){
        StudentDTO data = userService.getStuById(id);
        return new Result<StudentDTO>().ok(data);
    }


    @Login
    @GetMapping("stu/result/{id}")
    @ApiOperation("获取学生信息")
    public Result<List<TestResultDTO>> getStudentResult(@PathVariable("id") Long id){
        List<TestResultDTO> data = studentService.getTestResultById(id);
        return new Result<List<TestResultDTO>>().ok(data);
    }

}
