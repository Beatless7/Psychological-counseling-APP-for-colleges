package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginStudent;
import io.renren.common.utils.Result;
import io.renren.dao.QuestionMoreDao;
import io.renren.dto.Student_Score_DTO;
import io.renren.entity.StudentEntity;
import io.renren.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册接口
 *
 * @author Tjut team
 */
@RestController
@RequestMapping("/stu")
@Api(tags="分数接口")
public class Student_Score_Controller {
    @Autowired
    private StudentService studentService;

    @Autowired
    private QuestionMoreDao questionMoreDao;
    @Login
    @PostMapping("/student/StudentScore")
    @ApiOperation("学生分数")
    public Result getStudentByScore(@ApiIgnore  @LoginStudent StudentEntity student, @RequestBody Student_Score_DTO dto){
        Long id = student.getId();
        String name = student.getUsername();
        Integer number = dto.getScore();
        String str;
        if(number>=0&&number<=19){
            str = "心理正常";
        }else if(number>=20&&number<=39){
            str = "轻度抑郁";
        }else{
            str = "重度抑郁";
        }
        questionMoreDao.setByPsy(id,name,str,new DateTime());
        studentService.setStudentByPsy(id,str);
        return new Result().ok(work(str));
    }
    public Map work(String str){
        Map map1 = new HashMap();
        map1.put("心理正常", "建议你保持良好心态，感谢你对该产品的支持");  //向集合中添加对象
        Map map2 = new HashMap();
        map2.put("轻度抑郁","轻度抑郁症长期表现为有情绪低落、不合群、离群、躯体不适、食欲不振及睡眠障碍。" + "自我缓解方法有：平时多学习技术坚持锻炼、努力多外出交际：多观察多了解、平时整理好自己的想法写出来、多阅读书籍。部分患者可恢复工作能力。");
        Map map3 = new HashMap();
        map3.put("重度抑郁","重度抑郁症是由于患者个体内遗传系统（基因）存在异常，或后天环境的巨变所引起的一种情绪性功能障碍，以持久自发性的情绪低落为主的一系列抑郁症状。建议使用该产品，能够有效解决心理疾病");
        if(str == "心理正常"){
            return map1;
        }else if(str == "轻度抑郁"){
            return map2;
        }else{
            return map3;
        }
    }

}