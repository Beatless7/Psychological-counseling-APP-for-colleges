package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.Result;
import io.renren.dto.StudentDTO;
import io.renren.dto.UserListDTO;
import io.renren.entity.UserEntity;
import io.renren.service.UserListService;
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
    public Result getUserPsy(@ApiIgnore @RequestAttribute("userId") Long userId,@RequestBody UserListDTO dto,@ApiIgnore @LoginUser UserEntity teacher){
        Integer number = dto.getOrderStatus();
        if(number == 0){//0 未被预约
            number = 1;
        }else{
            number = 0;
            Long studentid=teacher.getOrderStudentId();
            userListService.teacherOrder(studentid);
            Long teacherid = teacher.getId();
            userListService.teacherOrder1(teacherid);
        }
        userListService.setUserPsy(userId,number);
        return new Result();
    }


    @Login
    @GetMapping("user/StudentList")
    @ApiOperation("获取学生信息")
    public Result<List<StudentDTO>> getAll(@ApiIgnore @LoginUser UserEntity user){
        List<StudentDTO> all = userListService.getAll(user.getOrderStudentId());
        return new Result<List<StudentDTO>>().ok(all);
    }

//    @Login
//    @PostMapping("user/order")
//    @ApiOperation("更改学生预约信息")
//    public Result<String> order2(@ApiIgnore @LoginUser UserEntity teacher){
//        Long studentid=teacher.getOrderStudentId();
//            String orderresult=userListService.teacherOrder(studentid);
//            return new Result<String>().ok(orderresult);
//    }

}
