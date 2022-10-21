// powered by 天津理工大学心理辅导团队

package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginStudent;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.Result;
import io.renren.entity.StudentEntity;
import io.renren.entity.UserEntity;
import io.renren.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 测试接口
 *
 * @author Tjut team
 */
@RestController
@RequestMapping("/api")
@Api(tags="测试接口")
public class ApiTestController {

    @Autowired
    StudentService studentService;

    @Login
    @GetMapping("/user/userInfo")
    @ApiOperation(value="获取教师管理员信息", response=UserEntity.class)
    public Result<UserEntity> userInfo(@ApiIgnore @LoginUser UserEntity user){
        return new Result<UserEntity>().ok(user);
    }

    /*@Login
    @GetMapping("/user/userInfo")
    @ApiOperation(value="获取教师管理员信息", response=UserEntity.class)
    public Result<String> userInfo(@ApiIgnore @LoginUser UserEntity user){

        return new Result<String>().ok(user.getUsername());
    }*/

    @Login
    @GetMapping("/stu/studentInfo")
    @ApiOperation(value="获取学生信息", response=StudentEntity.class)
    public Result<StudentEntity> studentInfo(@ApiIgnore @LoginStudent StudentEntity student){
        Long id=student.getId();
        return new Result<StudentEntity>().ok(student);
    }

    @Login
    @GetMapping("/stu/studentDept")
    @ApiOperation(value = "获取与当前登录学生院系id相同的所有学生",response = StudentEntity.class)
    public Result<List<StudentEntity>> samedeptidstudent(@ApiIgnore @LoginStudent StudentEntity student){
        Long deptId=student.getDeptId();

        List<StudentEntity> aa=studentService.getSameDeptStudent(deptId);

        return new Result<List<StudentEntity>>().ok(aa);
        //return new Result<StudentEntity>().ok(student);
    }

    @Login
    @GetMapping("/user/userId")
    @ApiOperation("获取用户ID")
    public Result<Long> userInfo(@ApiIgnore @RequestAttribute("userId") Long userId){
        return new Result<Long>().ok(userId);
    }

    @Login
    @GetMapping("/stu/studentId")
    @ApiOperation("获取学生ID")
    public Result<Long> studentInfo(@ApiIgnore @RequestAttribute("studentId") Long studentId){
        return new Result<Long>().ok(studentId);
    }

    @GetMapping("notToken")
    @ApiOperation("忽略Token验证测试")
    public Result<String> notToken(){
        return new Result<String>().ok("无需token也能访问。。。");
    }

}