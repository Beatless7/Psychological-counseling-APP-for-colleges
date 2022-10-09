package io.renren.controller;

import io.renren.common.utils.Result;
import io.renren.common.validator.ValidatorUtils;
import io.renren.dto.Student_Score_DTO;
import io.renren.entity.StudentEntity;
import io.renren.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册接口
 *
 * @author Tjut team
 */
@RestController
@RequestMapping("/api")
@Api(tags="分数接口")
public class Student_Score_Controller {
    @Autowired
    private StudentService studentService;

    @PostMapping("Student_Score")
    @ApiOperation("学生分数")
    public Result getStudentByScore(@RequestBody Student_Score_DTO dto){
        ValidatorUtils.validateEntity(dto);

        StudentEntity student = new StudentEntity();
        student.setId(dto.getId());
        int number = dto.getScore();
        String str;
        if(number>=0&&number<=19){
            str = "正常";
        }else if(number>=20&&number<=39){
            str = "轻度抑郁";
        }else{
            str = "重度抑郁";
        }
        student.setPsyStates(str);
        studentService.insert(student);
        return new Result();
    }

}