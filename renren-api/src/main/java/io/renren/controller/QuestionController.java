package io.renren.controller;

import io.renren.common.utils.Result;
import io.renren.dto.QuestionDTO;
import io.renren.service.QuestionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/app")
@Api(tags = "问卷管理")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("question")
    public Result<List<QuestionDTO>> list() {
        List<QuestionDTO> data = questionService.list();
        return new Result<List<QuestionDTO>>().ok(data);
    }

}
